package com.techknow.bigkas;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentManager;

import com.techknow.bigkas.base.BaseFragment;
import com.techknow.bigkas.home.HomeFragment;

public class AboutFragment extends BaseFragment {
    ImageButton imageButton;
    public AboutFragment() {
        super(R.layout.fragment_about);
    }

    @Override
    public void initView(View view) {
        imageButton = view.findViewById(R.id.back_btn);
        //codee here for back button
    }
}