package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.main.view.HomeFriendFragment;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeFriendPresenterImpl extends BasePresenter<HomeFriendFragment> implements HomeFriendPresenter.Presenter {

    public HomeFriendPresenterImpl(HomeFriendFragment mView) {
        super(mView);
    }

    @Override
    public void fetchHisFriends(String version, String module, String view, String from, String uid) {
        RetrofitHelper
                .getHisFriendsApi()
                .fetchHisFriends(version, module, view, from, uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<MyFriendsResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<MyFriendsResult> scenicInfo) {
                        mView.showHisFriends(scenicInfo);
                    }
                });
    }
}