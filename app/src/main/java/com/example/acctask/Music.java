package com.example.acctask;


public class Music {

    private long id;
    private String name;
    private String singer;
    private int  path;
    private int  image;
    private boolean isPlaying;

    public Music(long id, String name, String singer, int path, int image, boolean isPlaying) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.path = path;
        this.image = image;
        this.isPlaying = isPlaying;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
