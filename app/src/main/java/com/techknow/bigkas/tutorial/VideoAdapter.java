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
        /**
         * Inflates the view (rectangle container with initial textviews).
         * Passed the view into VideoViewHolder.
         */
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.tutorial_steps_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VideoViewHolder holder, int position) {
        /**
         * Finds the position of the array (VideoContentItems).
         * Each are passed into the videoContent to get the ID of the texts.
         * Bind is used to pass and set the content of the array into the textviews
         * along with the container.
         */
        final Thumbnail thumbnail = ThumbnailItems.ITEMS.get(position);
        holder.bind(thumbnail);
        /**
         * Gets the position of the clicked item
         */
        holder.itemView.setOnClickListener(v -> thumbnailClickListener.onThumbnailClick(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return ThumbnailItems.ITEMS.size();
    }
}



