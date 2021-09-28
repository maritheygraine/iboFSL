package com.techknow.bigkas.tutorial;

public class Thumbnail {
    /**
     * Method used to get the ID of the textviews.
     */
    private final String eng;
    private final String fil;
    private final int videoId;

    public Thumbnail (String eng, String fil, int videoId){
        this.eng = eng;
        this.fil = fil;
        this.videoId = videoId;
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