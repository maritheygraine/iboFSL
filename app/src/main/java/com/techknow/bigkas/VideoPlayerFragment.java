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
        /**
         * Gets video path
         */
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + thumbnailArgs().getVideoId();
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        /**
         * Methods and setting for media player.
         * Looped video is on and volume is muted.
         * Play/Pause controller is hidden.
         */
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

        mediaController.hide();
    }

    public VideoPlayerFragment(){
        super(R.layout.fragment_video_viewer);
    }

    @Override
    public void initView(View view) {
        setVideoViewer(view.findViewById(R.id.videoPlayer));
        super.toolbarPopBackStack(view.findViewById(R.id.toolbar));

        TextView englishText = view.findViewById(R.id.english_trans);
        TextView filipinoText = view.findViewById(R.id.filipino_trans);

        /**
         * Sets the textview with the index's content.
         */
        englishText.setText(thumbnailArgs().getEng());
        filipinoText.setText(thumbnailArgs().getFil());

        /**
         * When the check button is clicked,the videoplayer will redirect to the
         * recognition module
         */
        view.findViewById(R.id.check_btn).setOnClickListener(e -> {
            changeFragment(R.id.videoFragment_to_recognition);
        });
    }

    private void changeFragment(@IdRes int navId) {
        findNavController(this).navigate(navId);
    }

    private Thumbnail thumbnailArgs() {
        /**
         * Gets the index of container clicked
         * then sets the textview with the index's content.
         */
        assert getArguments() != null;
        int index = getArguments().getInt("index_positiion");
        return ThumbnailItems.ITEMS.get(index);
    }
}