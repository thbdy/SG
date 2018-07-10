package com.zhangf.unnamed.module.main.view;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.NetService;
import com.zhangf.unnamed.injector.component.DaggerNetServiceComponent;
import com.zhangf.unnamed.injector.module.NetServiceModule;
import com.zhangf.unnamed.module.main.presenter.ThreadPresenter;
import com.zhangf.unnamed.module.main.presenter.ThreadPresenterImpl;

public class ThreadActivity extends BaseActivity<ThreadPresenterImpl> implements ThreadPresenter.View{
    private String mTid;
    @Override
    protected void initData() {
        mPresenter.fetchCheckPost();
        mPresenter.fetchThreadInfo(mTid);

    }

    @Override
    protected void initView() {
        mTid = getIntent().getStringExtra("tid");


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_thread;
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().netServiceModule(new NetServiceModule(NetService.BASE_URL2)).build().injectThreadActivity(this);
    }

    @Override
    public void setState(String state, String msg) {

    }


    @Override
    public void showThreadInfo(BaseResponse2 result) {

    }

    @Override
    public void showCheckPost(BaseResponse2 result) {

    }
}
