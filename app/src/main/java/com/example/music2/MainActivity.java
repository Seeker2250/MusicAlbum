package com.example.music2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("노래 목록");//Activity 이름 수정
    }
    public void play(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) findViewById(id);//LinearLayout 취득
        String tag = (String) layout.getTag();

        Intent it = new Intent(this, AudioImage.class);//Intent object 생성
        it.putExtra("it_tag", tag);
        startActivity(it);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()){
            mp.stop();
        }
    }
}