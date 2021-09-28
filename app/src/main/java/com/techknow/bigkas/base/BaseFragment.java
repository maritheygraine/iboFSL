package com.techknow.bigkas.base;

import static androidx.navigation.fragment.NavHostFragment.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public abstract class BaseFragment extends Fragment {
    /**
     * Build in methods in each fragment moved into one class
     * to reduce repetition and make it reusable.
     */

    private final @LayoutRes int layout;

    public BaseFragment(final @LayoutRes int layout) {
        /**
         * Constructor ussd to get the current layout of a certain fragment.
         */
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    public abstract void initView(final View view);



    public void toolbarPopBackStack(final Toolbar toolbar) {
        /**
         *  Method used to go to the previous fragment.
         *  Simply, for the back button/function.
         */
        toolbar.setNavigationOnClickListener(e -> findNavController(this).navigateUp());
    }
}
