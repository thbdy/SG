package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.ChatResult;
import com.zhangf.unnamed.module.main.model.SendMessageResult;

public class ChatPresenter {
    interface Presenter{
        void fetchChat(String iyzmobile, String module, String version, String type, String uid, String touid);
        void fetchSendMessage(String touid,String formhash,String message);

    }
    public interface View extends BaseView {
        void showChat(BaseResponse2<ChatResult> result);
        void showSendMessage(SendMessageResult result);


    }
}
