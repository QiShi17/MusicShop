package com.example.a46639.testdownload.model.search;

/**
 * Created by 46639 on 2018/3/23.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by 46639 on 2018/3/22.
 */

public class Keys {
    private String id;
    private String name;
    private ArrayList<String> artists;
    private String album;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<String> artists) {
        this.artists = artists;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAllArtists(){
        String artistsString="";
        //new String("");
        int i;
        for(i=0;i<artists.size();i++)
        {
            if(i==0) artistsString+=artists.get(i);
            else artistsString+="/"+artists.get(i);
        }
        return artistsString;
    }


}


