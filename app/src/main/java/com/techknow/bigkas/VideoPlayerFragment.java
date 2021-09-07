package com.techknow.bigkas;

import android.net.Uri;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.techknow.bigkas.base.BaseFragment;
import com.techknow.bigkas.video.Thumbnail;
import com.techknow.bigkas.video.ThumbnailItems;

public class VideoPlayerFragment extends BaseFragment {

    private void setVideoViewer(VideoView videoView){
        int index = getArguments().getInt("index_positiion");
        final Thumbnail thumbnail = ThumbnailItems.ITEMS.get(index);

        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + thumbnail.getVideoId();
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(requireContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    public VideoPlayerFragment(){
        super(R.layout.fragment_video_viewer);
    }

    @Override
    public void initView(View view) {
        setVideoViewer(view.findViewById(R.id.videoPlayer));
        super.toolbarPopBackStack(view.findViewById(R.id.toolbar));

        int index = getArguments().getInt("index_positiion");
        final Thumbnail thumbnail = ThumbnailItems.ITEMS.get(index);

        TextView englishText = view.findViewById(R.id.english_trans);
        TextView filipinoText = view.findViewById(R.id.filipino_trans);

        englishText.setText(thumbnail.getEng());
        filipinoText.setText(thumbnail.getFil());


    }
}