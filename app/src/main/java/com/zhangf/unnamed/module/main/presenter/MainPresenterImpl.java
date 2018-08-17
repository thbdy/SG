package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.module.main.view.MainActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenterImpl extends BasePresenter<MainActivity> implements MainPresenter.Presenter{


    public MainPresenterImpl(MainActivity mView) {
        super(mView);
    }

    @Override
    public void fetchGetAll(String fid, String page) {
        RetrofitHelper
                .getAllApi()
                .fetchGetAll(fid,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<GetAllResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<GetAllResult> scenicInfo) {
                        mView.showGetAll(scenicInfo);
                    }
                });
    }

    @Override
    public void fetchThemeList(String fid, String page) {
        RetrofitHelper
                .getThemeListApi()
                .fetchThemeList(fid,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<ThemeListResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<ThemeListResult> scenicInfo) {
                        mView.showThemeList(scenicInfo);
                    }
                });
    }
}
