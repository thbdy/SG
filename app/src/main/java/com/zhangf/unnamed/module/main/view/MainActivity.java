package com.zhangf.unnamed.module.main.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.ThemeListAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.NetService;
import com.zhangf.unnamed.injector.component.DaggerNetServiceComponent;
import com.zhangf.unnamed.injector.module.NetServiceModule;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.module.main.presenter.MainPresenter;
import com.zhangf.unnamed.module.main.presenter.MainPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainPresenter.View, OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    private int mPage = 1;
    private ThemeListAdapter themeListAdapter;
    private List<ThemeListResult.ForumThreadlistBean> threadlistBeanList = new ArrayList<>();

    @Override
    protected void initData() {
        mPresenter.fetchThemeList("44", String.valueOf(mPage));

    }

    @Override
    protected void initView() {
        rvData.setLayoutManager(new LinearLayoutManager(this));
        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().netServiceModule(new NetServiceModule(NetService.BASE_URL2)).build().injectMainactivity(this);
    }

    @Override
    public void setState(String state, String msg) {

    }


    @Override
    public void showGetAll(BaseResponse2<GetAllResult> result) {


    }

    @Override
    public void showThemeList(BaseResponse2<ThemeListResult> result) {
        if(mPage == 1) {
            smartRefreshLayout.finishRefresh(0);
        }else {
            smartRefreshLayout.finishLoadMore();
        }

        if (result.getRequest_id().equals("0") && result.getVariables().getForum_threadlist().size() > 0) {
            if (themeListAdapter == null) {
                themeListAdapter = new ThemeListAdapter(threadlistBeanList);
                themeListAdapter.bindToRecyclerView(rvData);
            }
            if(mPage == 1){
                threadlistBeanList.clear();
            }
            threadlistBeanList.addAll(result.getVariables().getForum_threadlist());
            themeListAdapter.notifyDataSetChanged();
        }else {
            mPage --;
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
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPage = 1;
        initData();

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPage++;
        initData();

    }
}
