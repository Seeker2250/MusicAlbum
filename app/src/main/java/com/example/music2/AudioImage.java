package com.example.music2;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AudioImage extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //audio image 띄워줘 화면에
        setContentView(R.layout.audio_image);

        setTitle("노래 재생");

        //tag 추출
        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        //object 획득
        TextView title = findViewById(R.id.title);
        ImageView song_image = findViewById(R.id.song_image);
        TextView lyrics = findViewById(R.id.lyrics);

        Resources res = getResources();

        int stringId;
        String mkKey;

        stringId = res.getIdentifier("title"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        title.setText(mkKey);//제목 출력

        stringId = res.getIdentifier("song_image"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int imageId = res.getIdentifier(mkKey, "drawable", getPackageName());
        song_image.setImageResource(imageId);//이미지 출력

        stringId = res.getIdentifier("lyrics"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        lyrics.setText(mkKey);//가사 출력

        stringId = res.getIdentifier("audio"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int audioId = res.getIdentifier(mkKey, "raw", getPackageName());//오디오 재생

        mp = MediaPlayer.create(this, audioId);
        mp.setLooping(false);
        mp.start();
    } //end of onCreate
}
