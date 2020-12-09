package com.example.acctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AlbumMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_music);
        Bundle bundle = getIntent().getExtras();
        String album = bundle.getString("album");

        //List<Music> musicList = getSongList();
        List<Music> musicList = new ArrayList<>();
        musicList.add(new Music(1,"Ghungroo", "war", R.raw.ghungroo,R.drawable.war ,false));
        musicList.add(new Music(2,"jaijaishiv", "war", R.raw.jaijaishivshankar,R.drawable.war, false));
        musicList.add(new Music(2,"war", "war", R.raw.war,R.drawable.war, false));
        musicList.add(new Music(2,"chichore", "chichore", R.raw.chichore,R.drawable.chichore, false));
        musicList.add(new Music(2,"fikarnot", "chichore", R.raw.fikarnot,R.drawable.chichore, false));
        musicList.add(new Music(2,"khairyat", "chichore", R.raw.khairiyat,R.drawable.chichore, false));
        musicList.add(new Music(2,"wo din", "chichore", R.raw.wodin,R.drawable.chichore, false));
        musicList.add(new Music(2,"apna time", "gullyboy", R.raw.apnatime,R.drawable.gullyboy, false));
        musicList.add(new Music(2,"asli hiphop", "gullyboy", R.raw.aslihiphop,R.drawable.gullyboy, false));
        musicList.add(new Music(2,"azadi", "gullyboy", R.raw.azadi,R.drawable.gullyboy, false));
        musicList.add(new Music(2,"doori", "gullyboy", R.raw.doori,R.drawable.gullyboy, false));
        musicList.add(new Music(2,"mere gully mai", "gullyboy", R.raw.meregullymai,R.drawable.gullyboy, false));
        musicList.add(new Music(2,"badla", "Housefull", R.raw.badla,R.drawable.housefull, false));
        musicList.add(new Music(2,"bala", "Housefull", R.raw.bala,R.drawable.housefull, false));
        musicList.add(new Music(2,"chammo", "Housefull", R.raw.chammo,R.drawable.housefull, false));
        musicList.add(new Music(2,"ek chumma", "Housefull", R.raw.ekchumma,R.drawable.housefull, false));
        musicList.add(new Music(2,"bhoot", "Housefull", R.raw.bhoot,R.drawable.housefull, false));
        musicList.add(new Music(2,"bekhayali", "kabirsingh", R.raw.bekhayali,R.drawable.kabir, false));
        musicList.add(new Music(2,"terabanjau", "kabirsingh", R.raw.terabanjau,R.drawable.kabir, false));
        musicList.add(new Music(2,"kaise hua", "kabirsingh", R.raw.kaisehua,R.drawable.kabir, false));
        musicList.add(new Music(2,"tuze kitna", "kabirsingh", R.raw.tuzekitna,R.drawable.kabir, false));
        musicList.add(new Music(2,"jaannisar", "kedarnath", R.raw.jaannisar,R.drawable.kedarnath, false));
        musicList.add(new Music(2,"namonamo", "kedarnath", R.raw.namonamo,R.drawable.kedarnath, false));
        musicList.add(new Music(2,"qaafirana", "kedarnath", R.raw.qaafirana,R.drawable.kedarnath, false));
        musicList.add(new Music(2,"sweetheart", "kedarnath", R.raw.sweetheart,R.drawable.kedarnath, false));
       // musicList.add(new Music(2,"abc", "satyamev", R.raw.dilbar, false));
       // musicList.add(new Music(2,"abc", "satyamev", R.raw.paniyosa, false));
       // musicList.add(new Music(2,"abc", "tamashaa", R.raw.heerto, false));
       // musicList.add(new Music(2,"abc", "tamashaa", R.raw.matargasti, false));
        //musicList.add(new Music(2,"abc", "tamashaa", R.raw.tumsat, false));

        List<Music> filterMusicList = new ArrayList<>();
        for (Music m:musicList) {
            if(m.getSinger().equalsIgnoreCase(album)){
                filterMusicList.add(m);
            }
        }
        ListView listView = (ListView) findViewById(R.id.musicList);
        MusicAdapter musicAdapter = new MusicAdapter(this,filterMusicList);
        listView.setAdapter(musicAdapter);
    }

    public List<Music> getSongList(){
        //query external audio
        List<Music> songList = new ArrayList<>();

        ContentResolver musicResolver = getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            //add songs to list
            do {
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                songList.add(new Music(thisId, thisTitle, thisArtist,0, R.drawable.war,false));
            }
            while (musicCursor.moveToNext());
            Log.d("abc", "abc");
        }
        return songList;
    }

}