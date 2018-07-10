package com.zhangf.unnamed.module.login.presenter;

import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.base.BaseView;

public class LoginPresenter {
    interface Presenter{
        void fetchLogin(String type,String token,String username,String password);

    }
    public interface View extends BaseView {
        void showLogin(BaseResponse<String> result);
    }
}
