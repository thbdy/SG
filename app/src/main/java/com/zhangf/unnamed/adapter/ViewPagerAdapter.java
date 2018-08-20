package com.zhangf.unnamed.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 创建人：os.zhangf
 * 类描述：-
 * 日期：2018/3/5
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private FragmentManager fm;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
