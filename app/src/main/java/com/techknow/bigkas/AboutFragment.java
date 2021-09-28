package com.techknow.bigkas;

import android.view.View;

import com.techknow.bigkas.base.BaseFragment;

public class AboutFragment extends BaseFragment {

    public AboutFragment() {
        super(R.layout.fragment_about);
    }

    @Override
    public void initView(View view) {
        /**
         * Method for back button.
         */
        super.toolbarPopBackStack(view.findViewById(R.id.toolbar));

    }
}