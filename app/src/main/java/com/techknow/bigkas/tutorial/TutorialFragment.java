package com.techknow.bigkas.tutorial;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.techknow.bigkas.R;
import com.techknow.bigkas.base.BaseFragment;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class TutorialFragment extends BaseFragment implements ThumbnailClickListener {

    public TutorialFragment(){
        super(R.layout.fragment_tutorial);
    }

    @Override
    public void initView(View view) {
        setVideoList(view.findViewById(R.id.video_list));
    }

    private void setVideoList(RecyclerView recyclerView){
        recyclerView.setAdapter(new VideoAdapter(this));
    }



    @Override
    public void onThumbnailClick(int index) {
        /**
         * Changes the fragment when a container is clicked.
         */
        Bundle bundle = new Bundle();
        bundle.putInt("index_positiion",index);

        changeFragment(R.id.homevideo_to_videoViewer, bundle);
    }

    private void changeFragment(@IdRes int navId, Bundle bundle) {
        findNavController(this).navigate(navId, bundle);
    }

}
