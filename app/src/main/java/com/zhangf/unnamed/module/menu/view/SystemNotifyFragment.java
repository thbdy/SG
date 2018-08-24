package com.zhangf.unnamed.module.menu.view;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.module.menu.presenter.SystemNotifyPresenter;
import com.zhangf.unnamed.module.menu.presenter.SystemNotifyPresenterImpl;

/**
 * 系统通知
 * Created by 75232 on 2018/8/20
 */
public class SystemNotifyFragment extends BaseFragment<SystemNotifyPresenterImpl> implements SystemNotifyPresenter.View {
    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_system_notify;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected SystemNotifyPresenterImpl initPresenter() {
        return new SystemNotifyPresenterImpl(this);
    }

}
