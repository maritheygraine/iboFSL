package com.techknow.bigkas.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;
import com.techknow.bigkas.base.Binder;

public class HomeViewHolder extends RecyclerView.ViewHolder implements Binder<HomeContent> {

    private final TextView description;
    private final ImageView number;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        description = itemView.findViewById(R.id.description);
        number = itemView.findViewById(R.id.number);
    }

    @Override
    public void bind(HomeContent data) {
        this.description.setText(data.getData());
        number.setImageResource(data.getDrawable_id());
    }
}