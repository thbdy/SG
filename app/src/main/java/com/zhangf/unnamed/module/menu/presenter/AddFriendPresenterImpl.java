package com.zhangf.unnamed.module.menu.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.menu.model.AddFriendResult;
import com.zhangf.unnamed.module.menu.view.AddFriendActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 75232 on 2018/8/20

 */
public class AddFriendPresenterImpl extends BasePresenter<AddFriendActivity> implements AddFriendPresenter.Presenter{

    public AddFriendPresenterImpl(AddFriendActivity mView) {
        super(mView);
    }

    @Override
    public void fetchAddFriend(String uid, String note, String fromhash) {
        RetrofitHelper
                .getAddFriendApi()
                .fetchMyFriends(uid, note, fromhash)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<AddFriendResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<AddFriendResult> scenicInfo) {
                        mView.showAddFriend(scenicInfo);
                    }
                });
    }
}
