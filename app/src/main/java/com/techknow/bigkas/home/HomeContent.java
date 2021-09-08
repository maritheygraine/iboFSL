package com.techknow.bigkas.home;

public class HomeContent {
    private final int picture_id;
    private final int data;

    public HomeContent (int drawable_id, int data){
        this.picture_id = drawable_id;
        this.data = data;
    }

    public int getDrawable_id() {
        return picture_id;
    }

    public int getData() {
        return data;
    }

}
