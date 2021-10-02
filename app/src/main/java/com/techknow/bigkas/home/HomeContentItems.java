package com.techknow.bigkas.home;

import android.content.Context;
import android.content.res.Resources;

import com.techknow.bigkas.R;
import com.techknow.bigkas.tutorial.Thumbnail;

import java.util.ArrayList;
import java.util.List;

public class HomeContentItems {
    /**
     * Content of the array.
     */
    Context context;
    Resources resources;

    public static final List<HomeContent> ITEMS = new ArrayList<HomeContent>() {
        {
            add(new HomeContent(R.drawable.round_camera_24_purple, R.string.step_1));
            add(new HomeContent(R.drawable.round_emoji_people_24, R.string.step_2));
            add(new HomeContent(R.drawable.round_keyboard_alt_24_purple, R.string.step_3));
            add(new HomeContent(R.drawable.round_video_library_24_purple, R.string.step_4));
        }
    };

}
