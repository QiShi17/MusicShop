package com.example.a46639.testdownload.Util;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.example.a46639.testdownload.PlayActivity;
import com.example.a46639.testdownload.R;




public class Player {

    private static MediaPlayer mediaPlayer;

    private Context mcontext;

    public Player(Context context) {
        this.mcontext = context;
    }

    // 播放录音文件
    public void playSong(File file) {

        if (file.exists() && file != null) {
            if (mediaPlayer == null) {
                //Uri uri = Uri.fromFile(file);
                //mediaPlayer = MediaPlayer.create(mcontext, uri);
                mediaPlayer=MediaPlayer.create(mcontext,Uri.parse("/mnt/sdcard/AAAAAAA/22.mp3"));

            }
            mediaPlayer.start();


           /* //监听MediaPlayer播放完成
            mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer paramMediaPlayer) {
                    // TODO Auto-generated method stub
                    //弹窗提示
                    Toast.makeText(mcontext,
                            mcontext.getResources().getString(R.string.ok),
                            Toast.LENGTH_SHORT).show();
                }
            });*/

        }
    }

    // 暂停播放录音
    public void pauseSong() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            Log.e("TAG", "暂停播放");
        }

    }

}
