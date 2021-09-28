package com.techknow.bigkas.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private Context context;

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * Inflates the view (rectangle container with initial textview and imageview).
         * Passed the view into HomeViewHolder.
         */
        this.context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.bigkas_steps_item, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        /**
         * Finds the position of the array (HomeContentItems).
         * Each are passed into the homeContent to get the ID of the picture and description.
         * Bind is used to pass and set the content of the array into the textview and imageview
         * along with the container.
         */
        final HomeContent homeContent = HomeContentItems.ITEMS.get(position);
        holder.bind(homeContent);
    }

    @Override
    public int getItemCount() {
        return HomeContentItems.ITEMS.size();
    }
}
