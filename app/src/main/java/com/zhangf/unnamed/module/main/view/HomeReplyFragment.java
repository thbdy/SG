package com.zhangf.unnamed.module.main.view;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.module.main.presenter.HomeReplyPresenter;
import com.zhangf.unnamed.module.main.presenter.HomeReplyPresenterImpl;

/**
 * 个人主页-TA的回复
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class HomeReplyFragment extends BaseFragment<HomeReplyPresenterImpl> implements HomeReplyPresenter.View{


    @Override
    protected void initData() {
        mPresenter.fetchHisReply("1", "mythread2", "4", "reply", mUid);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_reply;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomeReplyPresenterImpl initPresenter() {
        return new HomeReplyPresenterImpl(this);
    }

    @Override
    public void showHisReply(String result) {

    }
}
