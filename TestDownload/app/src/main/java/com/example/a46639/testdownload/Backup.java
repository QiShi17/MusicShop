package com.example.a46639.testdownload;

import android.view.View;
import android.widget.AdapterView;

import com.example.a46639.testdownload.adapters.SearchAdapter;
import com.example.a46639.testdownload.model.search.SearchBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 46639 on 2018/3/28.
 */

public class Backup {
    /*
    public void whenGetSearchSy(String address) throws IOException {
        Response response= HttpUtil.getOKhttp(address);
        final String responseString = "{\"keys\":"+response.body().string()+"}";

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Gson gson=new Gson();
                final SearchBean searchBean=gson.fromJson(responseString,SearchBean.class);

                //setAdapter to show data on ListView
                searchAdapter=new SearchAdapter(MainActivity.this,searchBean.keys);
                searchListView.setAdapter(searchAdapter);

                //listview onclickitem
                searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Toast.makeText(MainActivity.this,"Click iterm"+position,Toast.LENGTH_SHORT).show();
                        // final File newFile = new File("/mnt/sdcard/wohenqiguaiya//");
                        //newFile.mkdir();
                        String songid;
                        songid = searchBean.keys.get(position).getId();
                        //whenGetSearch("http://mrquin.space:80/download?stype=2&songID="+songid);

                    }
                });
            }
        });
    }

    public void whenGetDownLoad(String address)
    {
        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onResponse(Call call, Response response)  {


                //   final String responseString = response.body().string();

                 runOnUiThread(new Runnable() {
                         @Override
                         public void run() {

                                Toast.makeText(MainActivity.this,"get",Toast.LENGTH_LONG).show();


                         }

                 });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                // if getFail
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
    }

    public void whenGetSearch(String address)
    {
        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String responseString = "{\"keys\":"+response.body().string()+"}";

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Gson gson=new Gson();
                        final SearchBean searchBean=gson.fromJson(responseString,SearchBean.class);

                        //setAdapter to show data on ListView
                        searchAdapter=new SearchAdapter(MainActivity.this,searchBean.keys);
                        searchListView.setAdapter(searchAdapter);

                        //listview onclickitem
                        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // Toast.makeText(MainActivity.this,"Click iterm"+position,Toast.LENGTH_SHORT).show();
                                // final File newFile = new File("/mnt/sdcard/wohenqiguaiya//");
                                //newFile.mkdir();
                                String songid=searchBean.keys.get(position).getId();
                                //whenGetSearch("http://mrquin.space:80/download?stype=2&songID="+songid);

                            }
                        });
                    }
                });
                //whenGetSearch("http://www.baidu.com");
            }

            @Override
            public void onFailure(Call call, IOException e) {
                // if getFail
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
    }
    */
}
