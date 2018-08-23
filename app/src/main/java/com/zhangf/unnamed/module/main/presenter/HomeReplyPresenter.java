package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseView;

public class HomeReplyPresenter {
    interface Presenter{
        void fetchHisReply(String iyzmobile, String module, String version, String type, String uid);
    }
    public interface View extends BaseView {
        void showHisReply(String result);

    }
}
