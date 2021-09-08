package com.techknow.bigkas.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private static final List<Integer> ITEMS = new ArrayList<Integer>() {
        {
            add(R.string.step_1);
            add(R.string.step_2);
            add(R.string.step_3);
            add(R.string.step_4);
            add(R.string.step_5);
        }
    };

    private Context context;

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.bigkas_steps_item, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        final Resources resources = context.getResources();
        holder.bind(resources.getString(ITEMS.get(position)));
    }

    @Override
    public int getItemCount() {
        return ITEMS.size();
    }
}
