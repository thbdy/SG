package com.zhangf.unnamed.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhangf.unnamed.http.LifeSubscription;
import com.zhangf.unnamed.http.Stateful;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements Stateful ,LifeSubscription {
    private String TAG;
    private CompositeSubscription mCompositeSubscription;

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        TAG = getClass().getSimpleName();
        initView();
        initInject();
        mPresenter.attachView(this);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
//        dismissSessionFailedDialog();
    }


    /**
     * dagger2注入
     */
    protected abstract void initInject();
    //用于添加rx的监听的在onDestroy中记得关闭不然会内存泄漏。
    @Override
    public void bindSubscription(Subscription subscription) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(subscription);
    }


}
