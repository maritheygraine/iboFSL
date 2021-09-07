package com.techknow.bigkas.home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;
import com.techknow.bigkas.base.Binder;

public class HomeViewHolder extends RecyclerView.ViewHolder implements Binder<String> {

    private final TextView description;
    private final TextView number;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        description = itemView.findViewById(R.id.description);
        number = itemView.findViewById(R.id.number);
    }

    @Override
    public void bind(String data) {
        this.description.setText(data);
        this.number.setText(String.valueOf(getAdapterPosition() + 1));
    }
}