package com.techknow.bigkas.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

        hamburger.setOnClickListener(e -> menu.show());
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        // dito mo lagay yung mga ipapalabas mo na items
        return false;
    }
}