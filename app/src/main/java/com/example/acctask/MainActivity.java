package com.example.acctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((CardView) findViewById(R.id.war)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("War");
            }
        });
        ((CardView) findViewById(R.id.kabir)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("kabirsingh");
            }
        });
        ((CardView) findViewById(R.id.chhichhore)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("chichore");
            }
        });
        ((CardView) findViewById(R.id.gullyboy)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("gullyboy");
            }
        });
        ((CardView) findViewById(R.id.HouseFullFour)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("Housefull");
            }
        });
        ((CardView) findViewById(R.id.Kedarnath)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("kedarnath");
            }
        });

    }
    private void openActivity(String album){
        Intent intent = new Intent(this, AlbumMusicActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("album", album);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}