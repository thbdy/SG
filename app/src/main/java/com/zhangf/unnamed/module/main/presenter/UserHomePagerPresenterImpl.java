package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.main.model.ProFileResult;
import com.zhangf.unnamed.module.main.view.UserHomePagerActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class UserHomePagerPresenterImpl extends BasePresenter<UserHomePagerActivity> implements UserHomePagerPresenter.Presenter{

    public UserHomePagerPresenterImpl(UserHomePagerActivity mView) {
        super(mView);
    }

    @Override
    public void fetchProFile(String uid,String module,String version) {
        RetrofitHelper
                .getProFileApi()
                .fetchProFile(uid, module, version)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<ProFileResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<ProFileResult> scenicInfo) {
                        mView.showProfile(scenicInfo);
                    }
                });
    }
}
