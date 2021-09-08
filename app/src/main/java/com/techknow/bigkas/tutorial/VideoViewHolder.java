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

    private final ImageView imageView;
    private final TextView endCap;
    private final TextView filCap;

    public VideoViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.thumbView);
        endCap = itemView.findViewById(R.id.title_video);
        filCap = itemView.findViewById(R.id.title_video2);
    }

    @Override
    public void bind(Thumbnail data) {
        imageView.setImageResource(data.getDrawable_id());
        endCap.setText(data.getEng());
        filCap.setText(data.getFil());
    }
}