package com.mrizkyyuhari.samsung.model;

public class MusicModel {
    private String artis, song;

    public MusicModel(String artis, String song) {
        this.artis = artis;
        this.song = song;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
