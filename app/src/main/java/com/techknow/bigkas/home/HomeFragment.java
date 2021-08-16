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

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void initView(View view) {
        setBigkasList(view.findViewById(R.id.bigkas_list));
        setPopupMenu(view.findViewById(R.id.hamburger));
    }

    private void setBigkasList(RecyclerView recyclerView) {
        recyclerView.setAdapter(new HomeAdapter());
    }

    private void setPopupMenu(final View hamburger) {
        final PopupMenu menu = new PopupMenu(requireContext(), hamburger);
        menu.inflate(R.menu.item_memu);
        menu.setOnMenuItemClickListener(this::onMenuItemClick);
        hamburger.setOnClickListener(e -> menu.show());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        // dito mo lagay yung mga ipapalabas mo na items
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                changeFragment(R.id.home_to_about);
                break;
            case R.id.nav_version:
                showToast("Bigkas version 1.0.0");
                // showToast("Check mo resource -> navigation folder -> nav_graph.xml");
                break;
            case R.id.nav_fingerspelling:
                changeFragment(R.id.home_to_feedback);
                //showToast("Then hover mo yung phone na may color green na + sign then add ka ng destination.");
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