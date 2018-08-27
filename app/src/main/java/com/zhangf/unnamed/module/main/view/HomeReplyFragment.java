package com.zhangf.unnamed.module.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.HisReplyAdapter;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.module.main.model.HisReplyResult;
import com.zhangf.unnamed.module.main.presenter.HomeReplyPresenter;
import com.zhangf.unnamed.module.main.presenter.HomeReplyPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 个人主页-TA的回复
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class HomeReplyFragment extends BaseFragment<HomeReplyPresenterImpl> implements HomeReplyPresenter.View {

    @BindView(R.id.rv_his_reply)
    RecyclerView rvHisReply;
    Unbinder unbinder;
    private HisReplyAdapter mAdapter;
    private List<HisReplyResult.DataBean> mDataList = new ArrayList<>();

    @Override
    protected void initData() {
//        mPresenter.fetchHisReply("1", "mythread2", "4", "reply", mUid);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_reply;
    }

    @Override
    protected void initView() {
        mAdapter = new HisReplyAdapter(R.layout.item_his_reply, mDataList);
        rvHisReply.setLayoutManager(new LinearLayoutManager(mContext));
        rvHisReply.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ThreadActivity.class);
                intent.putExtra("tid", mDataList.get(position).getTid());
                startActivity(intent);
            }
        });
    }

    @Override
    protected HomeReplyPresenterImpl initPresenter() {
        return new HomeReplyPresenterImpl(this);
    }

    @Override
    public void showHisReply(HisReplyResult result) {
        if (result.getRequest_id().equals("0")) {
            if (result.getData().size() > 0) {
                mDataList.clear();
                mDataList.addAll(result.getData());
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
