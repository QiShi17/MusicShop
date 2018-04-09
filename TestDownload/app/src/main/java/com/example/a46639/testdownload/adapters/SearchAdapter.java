package com.example.a46639.testdownload.adapters;

/**
 * Created by 46639 on 2018/3/23.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.a46639.testdownload.R;
import com.example.a46639.testdownload.model.search.Keys;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 46639 on 2018/3/23.
 */

public class SearchAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Keys> keys;

    public SearchAdapter(Context context, ArrayList<Keys> keys) {
        this.context = context;
        this.keys = keys;
    }

    @Override
    public int getCount() {
        return keys.size();
    }

    @Override
    public Object getItem(int position) {
        return keys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (converView == null) {
            converView = LayoutInflater.from(context).inflate(R.layout.search_listview_item, parent, false);
            viewHolder = new ViewHolder(converView);
            converView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) converView.getTag();
        }

        Keys currentItem=(Keys)getItem(position);
        viewHolder.songName.setText(currentItem.getName());
        viewHolder.artistAndAlbum.setText(currentItem.getAllArtists()+" - "+currentItem.getAlbum());

        viewHolder.listenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file=new File("/mnt/sdcard/TestDownload/");
                file.mkdir();
            }
        });

        return converView;

    }

    private class ViewHolder{
        TextView songName;
        TextView artistAndAlbum;
        Button listenbutton;

        public ViewHolder(View view){
            songName=(TextView)view.findViewById(R.id.text_view_songname);
            listenbutton=(Button)view.findViewById(R.id.listen_button);
            artistAndAlbum=(TextView)view.findViewById(R.id.text_view_artists_and_album);

        }
    }
}

