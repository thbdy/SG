package com.zhangf.unnamed.module.login.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseResponse3;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.login.view.LoginActivity;
import com.zhangf.unnamed.module.main.model.CheckPostResult;
import com.zhangf.unnamed.module.main.model.UserGoldResult;
import com.zhangf.unnamed.module.main.model.UserInfoResult;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenterImpl extends BasePresenter<LoginActivity> implements LoginPresenter.Presenter{


    public LoginPresenterImpl(LoginActivity mView) {
        super(mView);
    }

    @Override
    public void fetchLogin(String type, String token, String username, String password) {
        RetrofitHelper
                .getLoginApi()
                .fetchLoginInfo(type,token,username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse<String> scenicInfo) {
                        mView.showLogin(scenicInfo);
                    }
                });

    }

    @Override
    public void fetchUserInfo(String token, String apiToken) {
        RetrofitHelper
                .getUserInfoApi()
                .fetchUserInfo(token,apiToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse3<UserInfoResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse3<UserInfoResult> scenicInfo) {
                        mView.showUserInfo(scenicInfo);
                    }
                });
    }

    @Override
    public void fetchUserGold(String token, String apiToken) {
        RetrofitHelper
                .getUserGoldApi()
                .fetchUserGold(token,apiToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse3<UserGoldResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse3<UserGoldResult> scenicInfo) {
                        mView.showUserGold(scenicInfo);
                    }
                });
    }

    @Override
    public void fettchCheckPost() {
        RetrofitHelper
                .checkPostApi()
                .fetchCheckPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<CheckPostResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<CheckPostResult> scenicInfo) {
                        mView.showCheckPost(scenicInfo);
                    }
                });
    }

    @Override
    public void fetchTimeCode(String time ,String code) {
        RetrofitHelper
                .TimeCodeApi()
                .fetchTimeCode(time, code)
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
                        mView.showTimeCode(scenicInfo);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showTimeCode("");
                    }
                });
    }

}
