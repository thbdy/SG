package com.zhangf.unnamed.module.menu.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.module.menu.presenter.MyFocusPresenter;
import com.zhangf.unnamed.module.menu.presenter.MyFocusPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 75232 on 2018/8/20
 */
public class MyFocusActivity extends BaseActivity<MyFocusPresenterImpl> implements MyFocusPresenter.View {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void initToolBar(Bundle savedInstanceState) {
        tvTitle.setText("我的关注");
        ivBack.setVisibility(View.VISIBLE);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_focus;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected MyFocusPresenterImpl initPresenter() {
        return new MyFocusPresenterImpl(this);
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
}
