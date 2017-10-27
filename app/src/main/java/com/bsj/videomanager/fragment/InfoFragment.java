package com.bsj.videomanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bsj.videomanager.R;

/**
 * 信息Fragment
 * Created by George on 2017/10/25.
 */

public class InfoFragment extends BaseFragment {
    private View mVVersion, mVOnline, mVCarInfo, mVModule, mVStorage, mVCamera, mVVideotape, mVIpc, mVIc, mVCarState, mVDevice;
    private TextView mTvVersion, mTvOnline, mTvCarInfo, mTvModule, mTvStorage, mTvCamera, mTvVideotape, mTvIpc, mTvIc, mTvCarState, mTvDevice;
    /**文本框集合*/
    private TextView[] textViews;
    /**选中区分线集合*/
    private View[] selectBoder;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, null);
        init(view);
        return view;
    }

    private void init(View view) {
        mVVersion = view.findViewById(R.id.fragment_info_version_selected_v);
        mVOnline = view.findViewById(R.id.fragment_info_online_selected_v);
        mVCarInfo = view.findViewById(R.id.fragment_info_car_selected_v);
        mVModule = view.findViewById(R.id.fragment_info_module_selected_v);
        mVStorage = view.findViewById(R.id.fragment_info_storage_selected_v);
        mVCamera = view.findViewById(R.id.fragment_info_camera_selected_v);
        mVVideotape = view.findViewById(R.id.fragment_info_videotape_selected_v);
        mVIpc = view.findViewById(R.id.fragment_info_ipc_selected_v);
        mVIc = view.findViewById(R.id.fragment_info_ic_selected_v);
        mVCarState = view.findViewById(R.id.fragment_info_car_state_selected_v);
        mVDevice = view.findViewById(R.id.fragment_info_device_selected_v);
        mTvVersion = view.findViewById(R.id.fragment_info_version_tv);
        mTvOnline = view.findViewById(R.id.fragment_info_online_tv);
        mTvCarInfo = view.findViewById(R.id.fragment_info_car_tv);
        mTvModule = view.findViewById(R.id.fragment_info_module_tv);
        mTvStorage = view.findViewById(R.id.fragment_info_storage_tv);
        mTvCamera = view.findViewById(R.id.fragment_info_camera_tv);
        mTvVideotape = view.findViewById(R.id.fragment_info_videotape_tv);
        mTvIpc = view.findViewById(R.id.fragment_info_ipc_tv);
        mTvIc = view.findViewById(R.id.fragment_info_ic_tv);
        mTvCarState = view.findViewById(R.id.fragment_info_car_state_tv);
        mTvDevice = view.findViewById(R.id.fragment_info_device_tv);
        mTvVersion.setOnClickListener(onTypeClickListener);
        mTvOnline.setOnClickListener(onTypeClickListener);
        mTvCarInfo.setOnClickListener(onTypeClickListener);
        mTvModule.setOnClickListener(onTypeClickListener);
        mTvStorage.setOnClickListener(onTypeClickListener);
        mTvCamera.setOnClickListener(onTypeClickListener);
        mTvVideotape.setOnClickListener(onTypeClickListener);
        mTvIpc.setOnClickListener(onTypeClickListener);
        mTvIc.setOnClickListener(onTypeClickListener);
        mTvCarState.setOnClickListener(onTypeClickListener);
        mTvDevice.setOnClickListener(onTypeClickListener);
        TextView[] tempTextViews = {mTvVersion, mTvOnline, mTvCarInfo, mTvModule, mTvStorage, mTvCamera, mTvVideotape, mTvIpc, mTvIc, mTvCarState, mTvDevice};
        textViews = tempTextViews;
        View[] tempViews = {mVVersion, mVOnline, mVCarInfo, mVModule, mVStorage, mVCamera, mVVideotape, mVIpc, mVIc, mVCarState, mVDevice};
        selectBoder = tempViews;
        mTvVersion.performClick();
    }

    /**
     * 选项卡监听事件
     */
    private View.OnClickListener onTypeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int i = 0; i < textViews.length; i++) {
                textViews[i].setBackgroundResource(R.color.white);
                selectBoder[i].setVisibility(View.INVISIBLE);
                if (view.getId() == textViews[i].getId()) {
                    textViews[i].setBackgroundResource(R.color.main_background);
                    selectBoder[i].setVisibility(View.VISIBLE);
                }
            }
        }
    };

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.fragment_info_version_tv:
                break;

            default:
                break;
        }
    }


}
