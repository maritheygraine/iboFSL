package com.techknow.bigkas;

import android.view.View;

import com.techknow.bigkas.base.BaseFragment;

public class FeedbackFragment extends BaseFragment {

    public FeedbackFragment() {
        super(R.layout.fragment_feedback);
    }

    @Override
    public void initView(View view) {
        super.toolbarPopBackStack(view.findViewById(R.id.toolbar));
    }
}