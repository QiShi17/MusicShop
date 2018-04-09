package com.example.a46639.testdownload;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a46639.testdownload.Util.Player;

import java.io.File;

public class PlayActivity extends AppCompatActivity {

    // 播放按钮
    private Button playButton;
    // 暂停播放
    private Button pauseButton;
    private File songFile;
    private Player player;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Intent intent=getIntent();
        String songPathString=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText(songPathString);

        /*songFile=new File("/mnt/sdcard/AAAAAAA","22.mp3");

        initView();
        playButtonListener();
        pauseButtonListener();*/


    }

    private void initView() {
        playButton = (Button) findViewById(R.id.play_button);
        pauseButton = (Button) findViewById(R.id.pause_button);
    }

    private void playButtonListener() {
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(v.getContext(), "HEH", Toast.LENGTH_SHORT).show();
               MediaPlayer mediaPlayer=MediaPlayer.create(v.getContext(),Uri.parse("/mnt/sdcard/AAAAAAA/22.mp3"));
               mediaPlayer.start();
                //player=new Player(PlayActivity.this);
                //player.playSong(songFile);

            }
        });
    }

    private void pauseButtonListener() {
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // player.pauseSong();
            }
        });
    }





}
