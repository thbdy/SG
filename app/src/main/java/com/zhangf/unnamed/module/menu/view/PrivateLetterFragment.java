package com.zhangf.unnamed.module.menu.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.PrivateLetterAdapter;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.PrivateLetterResult;
import com.zhangf.unnamed.module.menu.presenter.MyMessagePresenter;
import com.zhangf.unnamed.module.menu.presenter.PrivateLetterPresenterImpl;
import com.zhangf.unnamed.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 私信
 * Created by 75232 on 2018/8/20
 */
public class PrivateLetterFragment extends BaseFragment<PrivateLetterPresenterImpl> implements MyMessagePresenter.View {
    @BindView(R.id.rv_private_letter)
    RecyclerView rvPrivateLetter;
    Unbinder unbinder;
    private List<PrivateLetterResult.ListBean> mPrivateLetterList;
    private PrivateLetterAdapter mAdapter;

    @Override
    protected void initData() {
//        String token = (String) SPUtils.get(App.getApp(),"token","");
//        String apiToken = (String) SPUtils.get(App.getApp(),"apiToken","");
//        mPresenter.fetchNotification(token,apiToken,"3");
        String formhash = (String) SPUtils.get(mContext, "formhash", "");
        mPresenter.fetchPrivateLetter("1", "mypm", "utf-8", formhash);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_private_letter;
    }

    @Override
    protected void initView() {
        mPrivateLetterList = new ArrayList<>();
        rvPrivateLetter.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new PrivateLetterAdapter(R.layout.item_private_letter, mPrivateLetterList);
        rvPrivateLetter.setAdapter(mAdapter);

    }

    @Override
    protected PrivateLetterPresenterImpl initPresenter() {
        return new PrivateLetterPresenterImpl(this);
    }

    @Override
    public void showNotification(String s) {

    }

    @Override
    public void showPrivateLetter(BaseResponse2<PrivateLetterResult> result) {
        if (result.getRequest_id().equals("0")) {
            mPrivateLetterList.clear();
            mPrivateLetterList.addAll(result.getVariables().getList());
            mAdapter.notifyDataSetChanged();
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
