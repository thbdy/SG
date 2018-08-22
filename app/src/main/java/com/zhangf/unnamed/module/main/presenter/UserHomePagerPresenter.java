package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.ProFileResult;

public class UserHomePagerPresenter {
    interface Presenter{

        void fetchProFile(String uid,String module,String version);
    }
    public interface View extends BaseView {
        void showProfile(BaseResponse2<ProFileResult> s);
    }
}
