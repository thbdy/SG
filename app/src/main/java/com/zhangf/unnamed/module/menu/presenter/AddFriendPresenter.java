package com.zhangf.unnamed.module.menu.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.menu.model.AddFriendResult;

public class AddFriendPresenter {
    interface Presenter{
        void fetchAddFriend(String uid,String note,String fromhash);
    }
    public interface View extends BaseView {
        void showAddFriend(BaseResponse2<AddFriendResult> s);

    }
}
