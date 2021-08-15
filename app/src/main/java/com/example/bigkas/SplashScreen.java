package com.example.bigkas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class SplashScreen extends AppCompatActivity {
    ImageView logo;
    Animation topAnim, obAnim;
    SharedPreferences onBoardingScreen;
    private static int SPLASH_SCREEN = 3000;
    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
        boolean isFirstTime = onBoardingScreen.getBoolean("isFirstTime",true);

        if (isFirstTime) {
            SharedPreferences.Editor editor = onBoardingScreen.edit();
            editor.putBoolean("isFirstTime",false);
            editor.commit();

            //Animation
            topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
            obAnim = AnimationUtils.loadAnimation(this,R.anim.ob_anim);
            logo = findViewById(R.id.logo);

            viewPager = findViewById(R.id.pager);
            pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(pagerAdapter);

            logo.setAnimation(topAnim);
            viewPager.startAnimation(obAnim);

        }
        else {
            topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
            logo = findViewById(R.id.logo);
            logo.setAnimation(topAnim);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },SPLASH_SCREEN);
        }


    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(@NotNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    OnBoarding_1 tab1 = new OnBoarding_1();
                    return tab1;
                case 1:
                    OnBoarding_2 tab2 = new OnBoarding_2();
                    return tab2;
                case 2:
                    OnBoarding_3 tab3 = new OnBoarding_3();
                    return tab3;
            }
            return null;

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public void skip (View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}