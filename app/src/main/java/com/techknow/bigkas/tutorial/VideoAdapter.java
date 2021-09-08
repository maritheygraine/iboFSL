package com.techknow.bigkas.tutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;

import org.jetbrains.annotations.NotNull;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private final ThumbnailClickListener thumbnailClickListener;


    public VideoAdapter(ThumbnailClickListener listener) {
        thumbnailClickListener = listener;
    }


    @NonNull
    @NotNull
    @Override

    public VideoViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.tutorial_steps_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VideoViewHolder holder, int position) {
        final Thumbnail thumbnail = ThumbnailItems.ITEMS.get(position);
        holder.bind(thumbnail);
        holder.itemView.setOnClickListener(v -> thumbnailClickListener.onThumbnailClick(holder.getAdapterPosition()));
        //get pos of cllicked item
    }

    @Override
    public int getItemCount() {
        return ThumbnailItems.ITEMS.size();
    }
}



