package com.example.bigkas.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bigkas.About;
import com.example.bigkas.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view.findViewById(R.id.bigkas_list));

        CardView cardView = view.findViewById(R.id.option_menu);
        cardView.setOnClickListener(v -> {
            getChildFragmentManager().beginTransaction().replace(R.id.home_linear, new About()).commit();
        });
    }

    private void initView(RecyclerView recyclerView) {
        recyclerView.setAdapter(new HomeAdapter());
    }
}