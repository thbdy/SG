package com.zhangf.unnamed.module.menu.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.menu.model.PrivateLetterResult;
import com.zhangf.unnamed.module.menu.view.PrivateLetterFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 75232 on 2018/8/20
 */
public class PrivateLetterPresenterImpl extends BasePresenter<PrivateLetterFragment> implements MyMessagePresenter.Presenter{


    public PrivateLetterPresenterImpl(PrivateLetterFragment mView) {
        super(mView);
    }

    @Override
    public void fetchNotification(String token, String apiToken, String type) {
        RetrofitHelper
                .notificationApi()
                .fetchNotification(token, apiToken, type)
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
                        mView.showNotification(scenicInfo);
                    }
                });
    }

    @Override
    public void fetchPrivateLetter(String version, String module, String charset, String formhash) {
        RetrofitHelper
                .getPrivateLetterApi()
                .fetchPrivateLetter(version, module, charset, formhash)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<PrivateLetterResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<PrivateLetterResult> scenicInfo) {
                        mView.showPrivateLetter(scenicInfo);
                    }
                });
    }
}
