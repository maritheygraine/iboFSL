package com.techknow.bigkas.splash;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.techknow.bigkas.R;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int[] LAYOUT_RESOURCE = new int[]{
            R.layout.activity_on_boarding1,
            R.layout.activity_on_boarding2,
            R.layout.activity_on_boarding3
    };

    public ScreenSlidePagerAdapter(@NotNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int i) {
        return OnBoardingPageFragment.newInstance(LAYOUT_RESOURCE[i]);
    }

    @Override
    public int getCount() {
        return LAYOUT_RESOURCE.length;
    }
}

