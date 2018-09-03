package com.zhangf.unnamed.module.menu.view;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.PrivateLetterResult;
import com.zhangf.unnamed.module.menu.presenter.MyMessagePresenter;
import com.zhangf.unnamed.module.menu.presenter.PrivateLetterPresenterImpl;

/**
 * 关于我
 * Created by 75232 on 2018/8/20
 */
public class AboutMeFragment extends BaseFragment<PrivateLetterPresenterImpl> implements MyMessagePresenter.View {
    @Override
    protected void initData() {
//        http://bbs.sgamer.com/forum.php?mod=viewthread&tid=13830384&viewpid=55249797&from=&inajax=1&ajaxtarget=post_new

//        mod: viewthread
//        tid: 13830384
//        viewpid: 55249797
//        from:
//        inajax: 1
//        ajaxtarget: post_new
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_about_me;
    }

    @Override
    protected void initView() {
//        https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=mypm&charset=utf-8&formhash=cb62d76a
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
