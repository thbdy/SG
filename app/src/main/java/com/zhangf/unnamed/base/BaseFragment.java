package com.zhangf.unnamed.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.zhangf.unnamed.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * author: zhangf
 * date: 2017年03月23日9:28
 * desc:
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment  {
    protected String TAG;
    protected Context mContext;
    protected View mRootView;
    private Unbinder unbind;
    protected T mPresenter;
    protected CompositeDisposable compositeSubscription;

    public String getmUid() {
        return mUid;
    }

    public void setmUid(String mUid) {
        this.mUid = mUid;
    }

    protected String mUid;
    private MaterialDialog mLoadingDialog;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        mContext = (BaseActivity) getActivity();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        unbind = ButterKnife.bind(this, mRootView);
        mPresenter = initPresenter();
        initView();
        initData();

        return mRootView;
    }

    protected abstract void initData();


    public abstract int getLayoutId();

    protected abstract void initView();

    protected abstract T initPresenter();


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


    public void showLoading() {
        //LoadingDialog.showLoadingDialog(getActivity());


    }

    public void showLoading(String msg) {
        // LoadingDialog.showLoadingDialog(getActivity(), msg, false);
    }

    public void hideLoading() {
        //  LoadingDialog.cancleDialog();

    }

    public void showEmpty() {

    }

    public void showError() {

    }
    public  void showSuccess(){

    }


    protected void showShortToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    protected void showLog(String msg) {
        Log.d(TAG, msg);
    }

    /**
     * 显示加载弹窗
     */
    public void showLoadingDialog(){
        if(mLoadingDialog == null){
            mLoadingDialog = new MaterialDialog.Builder(mContext)
                    .title(R.string.progress_dialog)
                    .content(R.string.please_wait)
                    .widgetColor(mContext.getResources().getColor(R.color.colorPrimary))
                    .progress(true, 100, false)
                    .build();
        }
        if(!mLoadingDialog.isShowing()){
            mLoadingDialog.show();
        }
    }
    /**
     * 显示加载弹窗
     */
    public void showLoadingDialog(String title){
        if(mLoadingDialog == null){
            mLoadingDialog = new MaterialDialog.Builder(mContext)
                    .title(title)
                    .content(R.string.please_wait)
                    .widgetColor(mContext.getResources().getColor(R.color.colorPrimary))
                    .progress(true, 100, false)
                    .build();
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
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        unSubscribe();
        unbind.unbind();
    }
}
