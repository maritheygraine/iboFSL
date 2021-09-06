package com.techknow.bigkas.video;

import android.os.Binder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techknow.bigkas.R;
import com.techknow.bigkas.home.HomeAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private final ThumbnailClickListener thumbnailClickListener;
    public VideoAdapter(ThumbnailClickListener listener){
        thumbnailClickListener = listener;
    }

    private static final List<Thumbnail> ITEMS = new ArrayList<Thumbnail>() {
        {
            add(new Thumbnail(R.drawable.samplehehe,"Hello","Kumusta"));
            add(new Thumbnail(R.drawable.samplehehe,"Hello","Kumusta"));
            add(new Thumbnail(R.drawable.samplehehe,"Hello","Kumusta"));
            add(new Thumbnail(R.drawable.samplehehe,"Hello","Kumusta"));
            add(new Thumbnail(R.drawable.samplehehe,"Hello","Kumusta"));
        }
    };

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
        holder.Bind(ITEMS.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thumbnailClickListener.onThumbnailClick(ITEMS.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return ITEMS.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView endCap;
        private final TextView filCap;

        public VideoViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.thumbView);
            endCap = itemView.findViewById(R.id.title_video);
            filCap = itemView.findViewById(R.id.title_video2);
        }

        public void Bind (Thumbnail thumbnail){
            imageView.setImageResource(thumbnail.getDrawable_id());
            endCap.setText(thumbnail.getEng());
            filCap.setText(thumbnail.getFil());
        }
    }
}


class Thumbnail {
    private int drawable_id;
    private String eng, fil;

    public Thumbnail (int drawable_id, String eng, String fil){
        this.drawable_id = drawable_id;
        this.eng = eng;
        this.fil = fil;
    }

    public int getDrawable_id() {
        return drawable_id;
    }

    public String getEng() {
        return eng;
    }

    public String getFil() {
        return fil;
    }
}
