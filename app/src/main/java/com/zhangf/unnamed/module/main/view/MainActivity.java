package com.zhangf.unnamed.module.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.maning.imagebrowserlibrary.MNImageBrowser;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.ThemeListAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.module.main.presenter.MainPresenter;
import com.zhangf.unnamed.module.main.presenter.MainPresenterImpl;
import com.zhangf.unnamed.utils.GlideImageEngine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainPresenter.View, OnRefreshListener, OnLoadMoreListener, TabLayout.OnTabSelectedListener {

    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    private int mPage = 1;
    private ThemeListAdapter themeListAdapter;
    private List<ThemeListResult.ForumThreadlistBean> threadlistBeanList = new ArrayList<>();
    private ArrayList<String> imageList = new ArrayList<>();

    private List<GetAllResult.ForumlistBean> tabList = new ArrayList<>();

    /**
     * 板块ID
     */
    private String mFid = "0";

    @Override
    protected void initData() {
        mPresenter.fetchGetAll("44","1");

    }

    @Override
    protected MainPresenterImpl initPresenter() {
        return new MainPresenterImpl(this);
    }




    /**
     * 图片浏览弹窗
     * @param position
     */
    private void showImageBrowseDialog(int position) {
        imageList.clear();
        imageList.addAll(threadlistBeanList.get(position).getAttachment_urls());
        MNImageBrowser.with(this)
                .setCurrentPosition(0)
                .setImageEngine(new GlideImageEngine())
                .setImageList(imageList)
                .setIndicatorHide(false)
                .show(rvData);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        rvData.setLayoutManager(new LinearLayoutManager(this));
        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
        //tab可滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addOnTabSelectedListener(this);



        themeListAdapter = new ThemeListAdapter(threadlistBeanList);
        themeListAdapter.bindToRecyclerView(rvData);


        themeListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showImageBrowseDialog(position);
                return false;
            }
        });
        themeListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this,ThreadActivity.class);
                intent.putExtra("tid",threadlistBeanList.get(position).getTid());
                startActivity(intent);
            }
        });
    }



    @Override
    public void showGetAll(BaseResponse2<GetAllResult> result) {
        if(result.getRequest_id().equals("0")){

            List<GetAllResult.ForumlistBean> tempList = new ArrayList<>();
            tempList.addAll(result.getVariables().getForumlist());
            for(int i = 0;i<tempList.size();i++){
                if(tempList.get(i).getName().toUpperCase().equals("DOTA2")){
                    tempList.remove(i);
                    tempList.add(0,result.getVariables().getForumlist().get(i));
                }
            }
            tabList.clear();
            tabList.addAll(tempList);

            for(GetAllResult.ForumlistBean forumlistBean : tabList){
                tabLayout.addTab(tabLayout.newTab().setText(forumlistBean.getName()));
            }
        }
    }

    @Override
    public void showThemeList(BaseResponse2<ThemeListResult> result) {
        if (mPage == 1) {
            smartRefreshLayout.finishRefresh(0);
        } else {
            smartRefreshLayout.finishLoadMore();
        }

        if (result.getRequest_id().equals("0") && result.getVariables().getForum_threadlist().size() > 0) {

            if (mPage == 1) {
                threadlistBeanList.clear();
            }
            threadlistBeanList.addAll(result.getVariables().getForum_threadlist());
            themeListAdapter.notifyDataSetChanged();
        } else {
            mPage--;
            Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initToolBar(Bundle savedInstanceState) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPage = 1;
        mPresenter.fetchThemeList(mFid, String.valueOf(mPage));

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPage++;
        mPresenter.fetchThemeList(mFid, String.valueOf(mPage));

    }

    /**
     * 导航栏滚动监听
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mFid = tabList.get(tab.getPosition()).getFid();
        mPresenter.fetchThemeList(tabList.get(tab.getPosition()).getFid(), String.valueOf(mPage));
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
