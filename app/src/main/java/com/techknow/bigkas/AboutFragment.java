package com.techknow.bigkas;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.techknow.bigkas.base.BaseFragment;

public class AboutFragment extends BaseFragment {

    public AboutFragment() {
        super(R.layout.fragment_about);
    }

    @Override
    public void initView(View view) {
        // pag madami kang instances ng toolbar
        // call mo lang tong method toolbarPopBackStack()
        // method ng BaseFragment yan inembed ko na para pede mo
        // nalang i-call if every inextend mo yung BaseFragment.

        // then lagay mo as argument yung instance ng toolbar for example.

        // ---------------------------------------------------------
        // Toolbar toolbar = view.findViewById(R.id.toolbar); <- hanapin mo yung view nya.
        // toolbarPopBackStack(toolbar);
        // ---------------------------------------------------------

        // pero check mo din yung fragment_about.xml yung
        // toolbar na view kung pano sya na aachieved.

        super.toolbarPopBackStack(view.findViewById(R.id.toolbar));
        //codee here for back button
    }
}