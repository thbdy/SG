package com.zhangf.unnamed.http.utils;

import android.util.Log;

import com.zhangf.unnamed.http.Stateful;
import com.zhangf.unnamed.utils.ErrorCodes;

import rx.Subscriber;


public class Callback<T> extends Subscriber<T> {
    private Stateful target;

    public void setTarget(Stateful target) {
        this.target = target;
    }

    public void detachView() {
        if (target != null) {
            target = null;
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
//        Logger.e(e.getMessage());
        Log.e("TAG", "onError: "+e.getMessage());
        onFailed();
    }

    @Override
    public void onNext(T data) {

        onResponse(data);
    }

    public void onResponse(T data) {

    }

    public void onFailed() {
        target.setState(ErrorCodes.COMMON_HTTP_ERROR,"");
    }
}
