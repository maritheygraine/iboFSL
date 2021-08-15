package com.techknow.bigkas.splash;

import android.content.Context;
import android.content.SharedPreferences;

public class OnBoardingPrefs {

    private final SharedPreferences preferences;

    public OnBoardingPrefs(Context context) {
       preferences = context.getSharedPreferences("onBoardingScreen", Context.MODE_PRIVATE);
    }

    public Boolean getOnBoardingPrefs() {
        final boolean isFirstTime = preferences.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            final SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();
        }

        return isFirstTime;
    }
}
