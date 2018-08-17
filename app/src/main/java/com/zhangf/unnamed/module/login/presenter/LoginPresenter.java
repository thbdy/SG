package com.zhangf.unnamed.module.login.presenter;

import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseResponse3;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.CheckPostResult;
import com.zhangf.unnamed.module.main.model.UserGoldResult;
import com.zhangf.unnamed.module.main.model.UserInfoResult;

public class LoginPresenter {
    interface Presenter{
        void fetchLogin(String type,String token,String username,String password);
        void fetchUserInfo(String token,String apiToken);
        void fetchUserGold(String token,String apiToken);
        void fettchCheckPost();
        void fetchTimeCode(String time,String code);

    }
    public interface View extends BaseView {
        void showLogin(BaseResponse<String> result);
        void showUserInfo(BaseResponse3<UserInfoResult> result);
        void showUserGold(BaseResponse3<UserGoldResult> result);
        void showCheckPost(BaseResponse2<CheckPostResult> s);
        void showTimeCode(String s);
    }
}
