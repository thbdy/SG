package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.ChatResult;

public class ChatPresenter {
    interface Presenter{
        void fetchChat(String iyzmobile, String module, String version, String type, String uid, String touid);

    }
    public interface View extends BaseView {
        void showChat(BaseResponse2<ChatResult> result);


    }
}
