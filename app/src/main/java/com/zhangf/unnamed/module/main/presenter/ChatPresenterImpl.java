package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseObserver;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.RetrofitHelper;
import com.zhangf.unnamed.module.main.model.ChatResult;
import com.zhangf.unnamed.module.main.model.SendMessageResult;
import com.zhangf.unnamed.module.main.view.ChatActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ChatPresenterImpl extends BasePresenter<ChatActivity> implements ChatPresenter.Presenter {

    public ChatPresenterImpl(ChatActivity mView) {
        super(mView);
    }

    @Override
    public void fetchChat(String iyzmobile, String module, String version, String type, String uid, String touid) {
        RetrofitHelper
                .getChatApi()
                .fetchChat(iyzmobile, module, version, type, uid, touid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResponse2<ChatResult>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(BaseResponse2<ChatResult> scenicInfo) {
                        mView.showChat(scenicInfo);
                    }
                });
    }

    @Override
    public void fetchSendMessage(String touid, String formhash, String message) {
        RetrofitHelper
                .getSendMessageApi()
                .fetchSendMessage(touid, formhash, message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<SendMessageResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addSubscribe(d);
                    }
                    @Override
                    protected void onNextSuccess(SendMessageResult scenicInfo) {
                        mView.showSendMessage(scenicInfo);
                    }
                });
    }
}