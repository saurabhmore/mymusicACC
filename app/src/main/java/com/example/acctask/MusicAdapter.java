package com.example.acctask;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private List<Music> musicList;
    public static Music music;
    public static MediaPlayer player;
    public static boolean isPlaying = false;

    public MusicAdapter(Context context, List<Music> musicList) {

        this.context = context;
        this.musicList = musicList;
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Music m = musicList.get(position);

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.music_items, null, true);

            holder.tvMusicName = (TextView) convertView.findViewById(R.id.tvMusicName);
            holder.music_img = (ImageView) convertView.findViewById(R.id.music_img);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tvMusicName.setText(m.getName());
        holder.music_img.setImageResource(m.getImage());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                music = m;
                Intent intent = new Intent(context, PlayerActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    private class ViewHolder {

        private TextView tvMusicName;
        private ImageView music_img;

    }

    private void play(int path){
        if(isPlaying){
            player.stop();
            isPlaying = false;
        }
        player = MediaPlayer.create(context,path);
        player.start();
        isPlaying = true;
    }

    private void pause(){
        player.pause();

    }

    private void stop(){
        player.stop();
        isPlaying = false;
    }

    private void next(){
        if(isPlaying){
            player.stop();
        }
        player = MediaPlayer.create(context, R.raw.apnatime);
        player.start();
        isPlaying = true;
    }
}