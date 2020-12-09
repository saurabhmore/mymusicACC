package com.example.acctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ((TextView)findViewById(R.id.song_name)).setText(MusicAdapter.music.getName());
        ((TextView)findViewById(R.id.song_artist)).setText(MusicAdapter.music.getSinger());
        ((ImageView)findViewById(R.id.cover_art)).setImageResource(MusicAdapter.music.getImage());

    }
}