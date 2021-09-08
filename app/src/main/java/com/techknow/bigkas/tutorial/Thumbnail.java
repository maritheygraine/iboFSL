package com.techknow.bigkas.tutorial;

public class Thumbnail {
    private final int drawable_id;
    private final String eng;
    private final String fil;
    private final int videoId;

    public Thumbnail (int drawable_id, String eng, String fil, int videoId){
        this.drawable_id = drawable_id;
        this.eng = eng;
        this.fil = fil;
        this.videoId = videoId;
    }

    public int getDrawable_id() {
        return drawable_id;
    }

    public String getEng() {
        return eng;
    }

    public String getFil() {
        return fil;
    }

    public int getVideoId() {
        return videoId;
    }
}