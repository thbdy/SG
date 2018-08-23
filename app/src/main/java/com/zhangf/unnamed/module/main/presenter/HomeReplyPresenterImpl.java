package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.main.view.HomeReplyFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeReplyPresenterImpl extends BasePresenter<HomeReplyFragment> implements HomeReplyPresenter.Presenter {

    public HomeReplyPresenterImpl(HomeReplyFragment mView) {
        super(mView);
    }

    @Override
    public void fetchHisReply(String iyzmobile, String module, String version, String type, String uid) {
        RetrofitHelper
                .getHisReplyApi()
                .fetchHisReply(iyzmobile, module, version, type, uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(String scenicInfo) {
                        mView.showHisReply(scenicInfo);
                    }
                });
    }
}