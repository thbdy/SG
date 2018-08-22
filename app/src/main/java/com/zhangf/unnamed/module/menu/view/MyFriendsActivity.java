package com.zhangf.unnamed.module.menu.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.MyFriendsAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;
import com.zhangf.unnamed.module.menu.presenter.MyFriendsPresenter;
import com.zhangf.unnamed.module.menu.presenter.MyFriendsPresenterImpl;
import com.zhangf.unnamed.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class MyFriendsActivity extends BaseActivity<MyFriendsPresenterImpl> implements MyFriendsPresenter.View {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_friends)
    RecyclerView rvFriends;
    private MyFriendsAdapter mAdapter;
    private List<MyFriendsResult.ListBean> mDataList = new ArrayList<>();

    @Override
    protected void initToolBar(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_friends;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvTitle.setText("我的好友");
        ivBack.setVisibility(View.VISIBLE);

        rvFriends.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyFriendsAdapter(R.layout.item_my_friend,mDataList);
        rvFriends.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        String formhash = (String) SPUtils.get(mContext, "formhash", "");
        mPresenter.fetchMyFriends(formhash);
    }

    @Override
    protected MyFriendsPresenterImpl initPresenter() {
        return new MyFriendsPresenterImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void showMyFriends(BaseResponse2<MyFriendsResult> result) {
        if(result.getRequest_id().equals("0")){
            mDataList.clear();
            mDataList.addAll(result.getVariables().getList());
            mAdapter.notifyDataSetChanged();

        }

    }
}
