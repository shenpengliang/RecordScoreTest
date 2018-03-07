package com.shenpengliang.sample.recordscoretest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

/**
 * Description: 春节视频
 * Created by shenpengliang on 2018/1/22.
 */

public class MainActivity3 extends Activity {
    private VideoView videoView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_3);
        videoView = findViewById(R.id.user_full_screen);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.e("shenpengliang",path);
//        videoView.setVideoURI();
    }

    public void benginVideo(View view) {
        if(videoView == null)
            return;
        if(videoView.isPlaying()){
            videoView.stopPlayback();
        }else{
            videoView.start();
        }
    }
}
