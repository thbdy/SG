package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.main.model.HisThreadResult;
import com.zhangf.unnamed.module.main.view.HomeThreadFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeThreadPresenterImpl extends BasePresenter<HomeThreadFragment> implements HomeThreadPresenter.Presenter {

    public HomeThreadPresenterImpl(HomeThreadFragment mView) {
        super(mView);
    }

    @Override
    public void fetchHisThread(String iyzmobile, String module, String version, String type, String uid) {
        RetrofitHelper
                .getHisThreadApi()
                .fetchHisThread(iyzmobile, module, version, type, uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HisThreadResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(HisThreadResult scenicInfo) {
                        mView.showHisThread(scenicInfo);
                    }
                });
    }
}