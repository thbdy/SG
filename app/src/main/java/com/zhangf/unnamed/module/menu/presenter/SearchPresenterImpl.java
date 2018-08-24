package com.zhangf.unnamed.module.menu.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.menu.view.SearchActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 75232 on 2018/8/20

 */
public class SearchPresenterImpl extends BasePresenter<SearchActivity> implements SearchPresenter.Presenter{

    public SearchPresenterImpl(SearchActivity mView) {
        super(mView);
    }

    @Override
    public void fetchSearch(String formhash, String srchtxt, String searchsubmit) {
        RetrofitHelper
                .getSearchApi()
                .fetchSearch(formhash, srchtxt, searchsubmit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse scenicInfo) {
                        mView.showSearch(scenicInfo);
                    }
                });
    }
}
