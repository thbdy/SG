package com.zhangf.unnamed.module.menu.view;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.PrivateLetterResult;
import com.zhangf.unnamed.module.menu.presenter.MyMessagePresenter;
import com.zhangf.unnamed.module.menu.presenter.PrivateLetterPresenterImpl;

/**
 * 系统通知
 * Created by 75232 on 2018/8/20
 */
public class SystemNotifyFragment extends BaseFragment<PrivateLetterPresenterImpl> implements MyMessagePresenter.View {
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
    protected PrivateLetterPresenterImpl initPresenter() {
//        return new MyMessagePresenterImpl(this);
        return null;
    }

    @Override
    public void showNotification(String s) {

    }

    @Override
    public void showPrivateLetter(BaseResponse2<PrivateLetterResult> s) {

    }
}
