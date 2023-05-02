package com.example.music2;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
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
        //액티비티 실행 요청한 intent를 취득해 tag 정보 획득
        //출력이 필요한 위젯을 인식, 저장(title, song image, lyrics
        //어떤 노래가 선택되었는지 tag정보를 파악해 적절한 내용과 노래를 출력
        setTitle("노래 재생");

        //tag 추출
        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        //object 획득
        TextView title = findViewById(R.id.title);
        ImageView song_image = findViewById(R.id.song_image);
        TextView lyrics = findViewById(R.id.lyrics);


        int stringId;
        String mkKey;
        //Resource 등록
        Resources res = getResources();

        stringId = res.getIdentifier("title" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        title.setText(mkKey);//제목 출력

        stringId = res.getIdentifier("song_image" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int imageId = res.getIdentifier(mkKey, "drawable", getPackageName());
        song_image.setImageResource(imageId);//이미지 출력

        stringId = res.getIdentifier("lyrics" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        lyrics.setText(mkKey);//가사 출력

        stringId = res.getIdentifier("audio" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int audioId = res.getIdentifier(mkKey, "raw", getPackageName());//오디오 재생


        mp = MediaPlayer.create(this, audioId);
        mp.setLooping(false);
        mp.start();
    } //end of onCreate

    public void goBack(View view) {
        //노래 재생중이면 중지하고 MediaPlayer 자원 해제하고 액티비티 종료
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        finish();
    }
}
