package com.techknow.bigkas.video;

class Thumbnail {
    private final int drawable_id;
    private final String eng;
    private final String fil;

    public Thumbnail (int drawable_id, String eng, String fil){
        this.drawable_id = drawable_id;
        this.eng = eng;
        this.fil = fil;
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
}