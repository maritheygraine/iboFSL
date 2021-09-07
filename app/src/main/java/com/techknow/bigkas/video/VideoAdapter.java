package com.techknow.bigkas.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;
import com.techknow.bigkas.base.Binder;
import com.techknow.bigkas.home.HomeAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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
        final View view = inflater.inflate(R.layout.video_steps_item, parent, false);
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



