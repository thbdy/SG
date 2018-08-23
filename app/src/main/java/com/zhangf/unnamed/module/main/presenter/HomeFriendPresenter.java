package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;

public class HomeFriendPresenter {
    interface Presenter{

        void fetchHisFriends(String version, String module, String view, String from, String uid);
    }
    public interface View extends BaseView {

        void showHisFriends(BaseResponse2<MyFriendsResult> result);

    }
}
