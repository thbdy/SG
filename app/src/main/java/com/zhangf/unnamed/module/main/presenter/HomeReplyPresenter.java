package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.HisReplyResult;

public class HomeReplyPresenter {
    interface Presenter{
        void fetchHisReply(String iyzmobile, String module, String version, String type, String uid);
    }
    public interface View extends BaseView {
        void showHisReply(HisReplyResult result);

    }
}
