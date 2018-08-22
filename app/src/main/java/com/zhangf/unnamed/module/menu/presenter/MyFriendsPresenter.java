package com.zhangf.unnamed.module.menu.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;

public class MyFriendsPresenter {
    interface Presenter{
        void fetchMyFriends(String formhash);


    }
    public interface View extends BaseView {
        void showMyFriends(BaseResponse2<MyFriendsResult> s);
    }
}
