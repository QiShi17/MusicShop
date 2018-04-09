package com.example.a46639.testdownload.model;

import android.util.Base64;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by 46639 on 2018/3/17.
 */

public class GetUpload {

    private String id;
    private String singername;
    private String songname;
    private String filecontent;


    public GetUpload(String id,String singername ,String songname,File file){
        this.id=id;
        this.singername=singername;
        this.songname=songname;
        this.setFilecontent(file);
    }

    public String getId(){
        return this.id;
    }

    public String getSongname(){
        return this.songname;
    }

    public String getSingername(){
        return this.singername;
    }

    public String getFilecontent(){
        return this.filecontent;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setSongname(String songname){
        this.songname=songname;
    }

    public void setSingername(String singername){
        this.singername=singername;
    }

    public void setFilecontent(File file){
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    //    byte[] encodedBytes = Base64.encode(bytes, 0);
        this.filecontent = new String(bytes);
    }
}
