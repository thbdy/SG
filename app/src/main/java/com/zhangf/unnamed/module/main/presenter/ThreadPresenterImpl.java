package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ThreadPresenterImpl extends BasePresenter<ThreadPresenter.View> implements ThreadPresenter.Presenter {


    public ThreadPresenterImpl(ThreadPresenter.View mView) {
        super(mView);
    }

    @Override
    public void fetchThreadInfo(String tid) {
        RetrofitHelper
                .getThreadInfoApi()
                .fetchThreadInfo(tid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2 scenicInfo) {
                        mView.showThreadInfo(scenicInfo);
                    }
                });
    }

    @Override
    public void fetchCheckPost() {

    }
}
