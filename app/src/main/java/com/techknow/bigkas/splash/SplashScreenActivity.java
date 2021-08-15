package com.techknow.bigkas.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.AnimRes;
import androidx.appcompat.app.AppCompatActivity;

import com.cuberto.liquid_swipe.LiquidPager;
import com.techknow.bigkas.MainActivity;
import com.techknow.bigkas.R;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView logo;
    Animation topAnim, obAnim;

    private static final int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final boolean isFinished = OnBoardingPrefs.getOnBoardingPrefs(getApplicationContext());

        logo = findViewById(R.id.logo);
        topAnim = animate(R.anim.top_animation);

        if (isFinished) {
            //Animation
            obAnim = animate(R.anim.ob_anim);

            final LiquidPager liquidPager = findViewById(R.id.pager);
            liquidPager.setAdapter(pagerAdapter());

            logo.setAnimation(topAnim);
            liquidPager.startAnimation(obAnim);
        } else {
            logo.setAnimation(topAnim);
            new Handler().postDelayed(this::createIntent, SPLASH_SCREEN);
        }
    }

    private ScreenSlidePagerAdapter pagerAdapter() {
        return new ScreenSlidePagerAdapter(getSupportFragmentManager());
    }

    private Animation animate(@AnimRes int resId) {
        return AnimationUtils.loadAnimation(this, resId);
    }

    public void skip(View view) {
        createIntent();
    }

    private void createIntent() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}