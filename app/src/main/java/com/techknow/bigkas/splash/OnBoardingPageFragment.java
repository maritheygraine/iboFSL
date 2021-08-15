package com.techknow.bigkas.splash;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OnBoardingPageFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            @LayoutRes final int layoutRes = getArguments().getInt("resource");
            return inflater.inflate(layoutRes, container, false);
        }
        throw new IllegalArgumentException();
    }

    public static OnBoardingPageFragment newInstance(@LayoutRes int resId) {
        final Bundle bundle = new Bundle();
        bundle.putInt("resource", resId);

       return createInstance(bundle);
    }

    private static OnBoardingPageFragment createInstance(Bundle bundle) {
        final OnBoardingPageFragment fragment = new OnBoardingPageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}