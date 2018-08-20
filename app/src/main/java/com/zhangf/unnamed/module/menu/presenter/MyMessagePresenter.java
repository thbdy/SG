package com.zhangf.unnamed.module.menu.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.menu.model.PrivateLetterResult;

public class MyMessagePresenter {
    interface Presenter{
        void fetchNotification(String token,String apiToken,String type);
        void fetchPrivateLetter(String version, String module, String charset, String formhash);

    }
    public interface View extends BaseView {
        void showNotification(String s);
        void showPrivateLetter(BaseResponse2<PrivateLetterResult> s);

    }
}
