package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.HisThreadResult;

public class HomeThreadPresenter {
    interface Presenter{
        void fetchHisThread(String iyzmobile, String module, String version, String type, String uid);
    }
    public interface View extends BaseView {
        void showHisThread(HisThreadResult result);

    }
}
