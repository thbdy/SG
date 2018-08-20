package com.zhangf.unnamed.module.menu.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.ViewPagerAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.module.menu.presenter.PrivateLetterPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的消息
 * Created by 75232 on 2018/8/20
 */
public class MyMessageActivity extends BaseActivity implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private AboutMeFragment aboutMeFragment;
    private PrivateLetterFragment privateLetterFragment;
    private SystemNotifyFragment systemNotifyFragment;
    private ViewPagerAdapter mAdapter;
    private List<Fragment> mFragmentList;

    @Override
    protected void initToolBar(Bundle savedInstanceState) {
        tvTitle.setText("我的消息");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_message;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTabLayout.addTab(mTabLayout.newTab().setText("关于我的"));
        mTabLayout.addTab(mTabLayout.newTab().setText("私信"));
        mTabLayout.addTab(mTabLayout.newTab().setText("系统通知"));

        mFragmentList = new ArrayList<>();
        mFragmentList.add(aboutMeFragment = new AboutMeFragment());
        mFragmentList.add(privateLetterFragment = new PrivateLetterFragment());
        mFragmentList.add(systemNotifyFragment = new SystemNotifyFragment());
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mAdapter);

        mTabLayout.addOnTabSelectedListener(this);
        mViewPager.addOnPageChangeListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected PrivateLetterPresenterImpl initPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {
        mTabLayout.getTabAt(position).select();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
