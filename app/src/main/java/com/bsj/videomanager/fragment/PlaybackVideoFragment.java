package com.bsj.videomanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsj.videomanager.R;

/**
 * 回放Fragment
 * Created by George on 2017/10/25.
 */

public class PlaybackVideoFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playback_video, null);
        return view;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
