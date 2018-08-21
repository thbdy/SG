package com.zhangf.unnamed.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhangf.unnamed.weight.LoadingDialog;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * author: zhangf
 * date: 2017年03月23日8:43
 * desc:
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public String TAG;
    protected Context mContext;
    protected T mPresenter;
    private CompositeDisposable compositeSubscription;
    private ButterKnife unbinder;
    private boolean doubleBackExit = false;
    private boolean doubleBackExitPressedOnce = false;

    private LoadingDialog mLoadingDialog;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG = getClass().getSimpleName();
        doBeforeSetContentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        //创建Presenter
        mPresenter = initPresenter();
        // mPresenter.onAttach(this);
        initToolBar(savedInstanceState);
        initView(savedInstanceState);
        initData();
    }

    protected abstract void initToolBar(Bundle savedInstanceState);



    protected abstract int getLayoutId();


    //设置layout前配置
    private void doBeforeSetContentView() {
    }


    //初始化view
    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    protected abstract T initPresenter();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        unSubscribe();
   //     unbinder.unbind();
    }

    /**
     * 显示加载弹窗
     */
    public void showLoadingDialog(){
        if(mLoadingDialog == null){
            mLoadingDialog = new LoadingDialog(mContext);
        }
        if(!mLoadingDialog.isShowing()){
            mLoadingDialog.show();
        }

    }

    /**
     * 关闭加载弹窗
     */
    public void dismissLoadingDialog(){
        if (null != mLoadingDialog) {
            if (mLoadingDialog.isShowing()) {
                mLoadingDialog.dismiss();
            }
        }
        mLoadingDialog = null;
    }


    public void addSubscribe(Disposable subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeDisposable ();
        }
        compositeSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (compositeSubscription != null)
            compositeSubscription.clear();

    }

}
