package com.zhangf.unnamed.module.login.presenter;

import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.http.NetService;
import com.zhangf.unnamed.http.utils.Callback;

import javax.inject.Inject;

public class LoginPresenterImpl extends BasePresenter<LoginPresenter.View> implements LoginPresenter.Presenter{
    NetService service;
    @Inject
    public LoginPresenterImpl(NetService service){
        this.service = service;
    }

    @Override
    public void fetchLogin(String m,String a,String username,String password) {
        invoke(service.fetchLoginInfo(m,a,username,password),new Callback<BaseResponse<String>>(){
            @Override
            public void onResponse(BaseResponse<String> data) {
                mView.showLogin(data);
            }
        });
    }
}
