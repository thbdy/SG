package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;

public class ThreadPresenter {
    interface Presenter{
        void fetchThreadInfo(String tid);
        void fetchCheckPost();
    }
    public interface View extends BaseView {
        void showThreadInfo(BaseResponse2 result);
        void showCheckPost(BaseResponse2 result);
    }
}
