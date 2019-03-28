package com.msi.studyonandroid.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.msi.studyonandroid.R;
import com.msi.studyonandroid.musicplayer.utils.HttpConnect;

public class MusicPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        HttpConnect.getSearch("123", HttpConnect.SearchType.SONG);
    }
}
