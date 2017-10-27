package com.bsj.videomanager.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bsj.videomanager.R;
import com.bsj.videomanager.fragment.InfoFragment;
import com.bsj.videomanager.fragment.MineFragment;
import com.bsj.videomanager.fragment.PlaybackVideoFragment;
import com.bsj.videomanager.fragment.RealTimeVideoFragment;
import com.bsj.videomanager.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    // 防爆点击记录上次点击ID
    int lastCheckId = 0;
    //上次点击底部4个Button时间
    private long lastClickTime = 0;

    private RadioGroup mRgTab;
    private RadioButton mRbInfo, mRbRealTime, mRbPlayback, mRbSetting, mRbMine;
    private InfoFragment infoFragment = new InfoFragment();
    private RealTimeVideoFragment realTimeVideoFragment = new RealTimeVideoFragment();
    private PlaybackVideoFragment playbackVideoFragment = new PlaybackVideoFragment();
    private SettingFragment settingFragment = new SettingFragment();
    private MineFragment mineFragment = new MineFragment();
    private FragmentManager fragmentManager;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setDefaultFragment();
    }

    private void init() {
        mRgTab = findViewById(R.id.main_tab_rg);
        mRbInfo =  findViewById(R.id.tab_info_rb);
        mRbRealTime =  findViewById(R.id.tab_real_time_video_rb);
        mRbPlayback =  findViewById(R.id.tab_playback_video_rb);
        mRbSetting =  findViewById(R.id.tab_setting_rb);
        mRbMine =  findViewById(R.id.tab_mine_rb);
        //定义底部标签图片大小
        Drawable info = getResources().getDrawable(R.drawable.tab_info_selector);
        Drawable realTime = getResources().getDrawable(R.drawable.tab_real_time_video_selector);
        Drawable playback = getResources().getDrawable(R.drawable.tab_playback_video_selector);
        Drawable setting = getResources().getDrawable(R.drawable.tab_setting_selector);
        Drawable mine = getResources().getDrawable(R.drawable.tab_mine_selector);
        int width = 32;
        info.setBounds(0, 0, width, width);
        mRbInfo.setCompoundDrawables(null, info, null, null);
        realTime.setBounds(0, 0, width, width);
        mRbRealTime.setCompoundDrawables(null, realTime, null, null);
        playback.setBounds(0, 0, width, width);
        mRbPlayback.setCompoundDrawables(null, playback, null, null);
        setting.setBounds(0, 0, width, width);
        mRbSetting.setCompoundDrawables(null, setting, null, null);
        mine.setBounds(0, 0, width, width);
        mRbMine.setCompoundDrawables(null, mine, null, null);
        fragmentList.add(infoFragment);
        fragmentList.add(realTimeVideoFragment);
        fragmentList.add(playbackVideoFragment);
        fragmentList.add(settingFragment);
        fragmentList.add(mineFragment);
        fragmentManager = getSupportFragmentManager();
        mRgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkId) {
                // 设置防爆点击
                if ((System.currentTimeMillis() - lastClickTime) > 100) {
                    lastCheckId = checkId;
                    lastClickTime = System.currentTimeMillis();
                    setFragmentById(checkId);
                } else {
                    mRgTab.check(lastCheckId);
                    return;
                }
            }
        });
    }

    /**
     * 设置默认Fragment
     */

    private void setDefaultFragment() {
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content, infoFragment).show(
                infoFragment);
        transaction.commit();
    }

    /**
     * 设置Fragment
     */
    public void setFragmentById(int checkId) {
        transaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragmentList.size(); i++) {
            if (!fragmentList.get(i).isHidden())
                transaction.hide(fragmentList.get(i));
        }
        switch (checkId) {
            case R.id.tab_info_rb:
                if (!infoFragment.isAdded())
                    transaction.add(R.id.content, infoFragment).show(
                            infoFragment);
                else
                    transaction.show(infoFragment);
                break;
            case R.id.tab_real_time_video_rb:
                if (!realTimeVideoFragment.isAdded())
                    transaction.add(R.id.content, realTimeVideoFragment).show(
                            realTimeVideoFragment);
                else
                    transaction.show(realTimeVideoFragment);
                break;
            case R.id.tab_playback_video_rb:
                if (!playbackVideoFragment.isAdded())
                    transaction.add(R.id.content, playbackVideoFragment).show(playbackVideoFragment);
                else
                    transaction.show(playbackVideoFragment);
                break;
            case R.id.tab_setting_rb:
                if (!mineFragment.isAdded())
                    transaction.add(R.id.content, settingFragment).show(
                            settingFragment);
                else
                    transaction.show(settingFragment);
                break;
            case R.id.tab_mine_rb:
                if (!mineFragment.isAdded())
                    transaction.add(R.id.content, mineFragment).show(
                            mineFragment);
                else
                    transaction.show(mineFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

}
