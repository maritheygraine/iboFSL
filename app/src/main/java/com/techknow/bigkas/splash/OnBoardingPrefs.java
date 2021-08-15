package com.techknow.bigkas.splash;

import android.content.Context;
import android.content.SharedPreferences;

public class OnBoardingPrefs {

    public static Boolean getOnBoardingPrefs(Context context) {
        final SharedPreferences preferences = context.getSharedPreferences("onBoardingScreen", Context.MODE_PRIVATE);

        final boolean isFirstTime = preferences.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            final SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();
        }

        return isFirstTime;
    }
}
