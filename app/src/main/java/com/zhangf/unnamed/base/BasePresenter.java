package com.zhangf.unnamed.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * author: zhangf
 * date: 2017年03月23日9:19
 * desc:
 */

public abstract class BasePresenter<T extends BaseView> {
    public T mView;

    protected CompositeDisposable compositeSubscription;


    public BasePresenter(T mView) {
        this.mView = mView;
    }


    public void onDestroy() {
        unSubscribe();
        mView = null;
    }

    /**
     * 用于解除订阅
     *
     * @param subscription
     */
    public void addSubscribe(Disposable subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeDisposable();
        }
        compositeSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (compositeSubscription != null)
            compositeSubscription.clear();
    }
}
