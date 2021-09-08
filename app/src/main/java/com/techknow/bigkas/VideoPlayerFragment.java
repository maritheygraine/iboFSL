package com.techknow.bigkas;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.IdRes;

import com.techknow.bigkas.base.BaseFragment;
import com.techknow.bigkas.tutorial.Thumbnail;
import com.techknow.bigkas.tutorial.ThumbnailItems;

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
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0,0);
                mp.setLooping(true);
            }
        });
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

        view.findViewById(R.id.check_btn).setOnClickListener(e -> {
            changeFragment(R.id.videoFragment_to_recognition);
        });
    }

    private void changeFragment(@IdRes int navId) {
        findNavController(this).navigate(navId);
    }
}