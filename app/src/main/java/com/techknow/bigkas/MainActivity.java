package com.techknow.bigkas;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = findNavController(this, R.id.fragment_container);
        setupNavBar();
    }

    private void setupNavBar() {
        /**
         * Bottom navigation
         */
        final PopupMenu popupMenu = new PopupMenu(this, null);
        popupMenu.inflate(R.menu.nav_menu);

        final SmoothBottomBar bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setupWithNavController(popupMenu.getMenu(), navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}