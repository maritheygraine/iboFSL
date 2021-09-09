package com.techknow.bigkas.tutorial;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;
import com.techknow.bigkas.base.Binder;

import org.jetbrains.annotations.NotNull;

public class VideoViewHolder extends RecyclerView.ViewHolder implements Binder<Thumbnail> {

    private final TextView endCap;
    private final TextView filCap;

    public VideoViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        endCap = itemView.findViewById(R.id.title_video);
        filCap = itemView.findViewById(R.id.title_video2);
    }

    @Override
    public void bind(Thumbnail data) {
        endCap.setText(data.getEng());
        filCap.setText(data.getFil());
    }
}