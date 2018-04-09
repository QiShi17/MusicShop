package com.example.a46639.testdownload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a46639.testdownload.adapters.SearchAdapter;
import com.example.a46639.testdownload.model.search.Keys;
import com.example.a46639.testdownload.model.search.SearchBean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.example.a46639.testdownload.model.GetUpload;

public class MainActivity extends AppCompatActivity {

    private SearchAdapter searchAdapter=null;
    private ListView searchListView;
    private TextView textView1;
    private TextView textView;
    private Button searchButton;
    private EditText searchEditText;
    private Gson gson;

    // private RelativeLayout mainRelativeLayout;
   // private Context mainActivityContext=this;

    public static final String EXTRA_MESSAGE = "com.example.a46639.testdownload.MESSAGE";


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    //public static final MediaType FORM = MediaType.parse("multipart/form-data");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchListView =(ListView)findViewById(R.id.list_view_search);
        searchButton=(Button)findViewById(R.id.search_button);
        searchEditText=(EditText)findViewById(R.id.search_song_edittext);
        textView1=(TextView)findViewById(R.id.textview1);



        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

               // textView1.setText(searchEditText.getText().toString().trim());

               // call_1();
                call_1(searchEditText.getText().toString().trim());
            }
        });

}

    private void call_1(String songname) {
        HttpUtil.sendOkHttpRequest("http://58.87.73.51:80/search?stype=1&songname="+songname, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseString = "{\"keys\":"+response.body().string()+"}";
                call_2(responseString);
            }
        });
    }

    private void call_2(final String tring) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                 gson=new Gson();
                 final SearchBean searchBean=gson.fromJson(tring,SearchBean.class);
                searchAdapter=new SearchAdapter(MainActivity.this,searchBean.keys);
                searchListView.setAdapter(searchAdapter);
                searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Keys key=searchBean.keys.get(position);

                        call_3(key.getId(),key.getName(),key.getAllArtists());

                        textView1.setText(key.getId());
                        //call_4("/mnt/sdcard/AAAAAAA/22.mp3");


                    }
                });
            }
        });
    }

    private void call_3(String songid, final String songname, final String allartists) {
        Call filed = HttpUtil.sendOkHttpRequest("http://58.87.73.51:80/download?stype=2&songID=" + songid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                call_4("Filed");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                File file = new File("/mnt/sdcard/MusicShopDownLoad//");
                file.mkdir();
                //  Toast.makeText(MainActivity.this, "goal", Toast.LENGTH_SHORT);
                final byte[] responseByte = response.body().bytes();
               final String songPathString = "/mnt/sdcard/AAAAAAA/"+songname+"-"+allartists+".mp3";
                FileOutputStream out = new FileOutputStream(songPathString);
                out.write(responseByte);
                out.close();

                call_4(songPathString);



            }
        });
    }

    private void call_4(final String songPathString) {
        runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                        String test = new String(songPathString);
                        intent.putExtra(EXTRA_MESSAGE, test);
                        textView=(TextView)findViewById(R.id.textview);
                        textView.setText(songPathString);
                        startActivity(intent);
                    }
                }
        );
    }

    private void call_5(final String songPathString) {

                        Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                        // intent.putExtra(EXTRA_MESSAGE, songPathString);

                        textView=(TextView)findViewById(R.id.textview);
                        textView.setText(songPathString);
                        startActivity(intent);

    }
}
