package com.techknow.bigkas.video;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.techknow.bigkas.R;
import com.techknow.bigkas.base.BaseFragment;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class VideoFragment extends BaseFragment implements ThumbnailClickListener {

    public VideoFragment (){
        super(R.layout.fragment_video);
    }

    @Override
    public void initView(View view) {
        setVideoList(view.findViewById(R.id.video_list));
    }

    private void setVideoList(RecyclerView recyclerView){
        recyclerView.setAdapter(new VideoAdapter(this));
    }


    @Override
    public void onThumbnailClick(Thumbnail thumbnail) {
        changeFragment(R.id.action_homevideo_to_videoViewer);
    }

    private void changeFragment(@IdRes int navId) {
        findNavController(this).navigate(navId);
    }

}
