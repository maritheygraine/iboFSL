package com.techknow.bigkas.home;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

import android.annotation.SuppressLint;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;
import com.techknow.bigkas.base.BaseFragment;

public class HomeFragment extends BaseFragment implements MenuItem.OnMenuItemClickListener {
    /**
     * This is the main view of the module Home. Where in the user can see
     * the manual of the app, techknow's description and contact information,
     * verson of the app, and the send feedback form
     */
    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void initView(View view) {
        /**
         * Puts each content into their respective layout.
         */
        setBigkasList(view.findViewById(R.id.bigkas_list));
        setPopupMenu(view.findViewById(R.id.hamburger));
    }

    private void setBigkasList(RecyclerView recyclerView) {
        recyclerView.setAdapter(new HomeAdapter());
    }

    private void setPopupMenu(final View hamburger) {
        /**
         * Inflate the content of the popup menu.
         * Show menu when clicked.
         */
        final PopupMenu menu = new PopupMenu(requireContext(), hamburger);
        menu.inflate(R.menu.item_memu);
        menu.setOnMenuItemClickListener(this::onMenuItemClick);
        hamburger.setOnClickListener(e -> menu.show());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        /**
         * This is used to change Fragments and show contents inside the popup menu.
         */
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                changeFragment(R.id.home_to_about);
                break;
            case R.id.nav_version:
                showToast("Bigkas version 1.0.0");
                // showToast("Check mo resource -> navigation folder -> nav_graph.xml");
                break;
            case R.id.nav_sendfeedback:
                changeFragment(R.id.home_to_feedback);
                break;
        }
        return false;
    }

    private void changeFragment(@IdRes int navId) {
        findNavController(this).navigate(navId);
    }

    private void showToast(final String message) {
        Toast.makeText(requireContext().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}