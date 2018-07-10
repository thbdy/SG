package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.NetService;
import com.zhangf.unnamed.http.utils.Callback;

import javax.inject.Inject;

public class ThreadPresenterImpl extends BasePresenter<ThreadPresenter.View> implements ThreadPresenter.Presenter {
    NetService service;

    @Inject
    public ThreadPresenterImpl(NetService service) {
        this.service = service;
    }

    @Override
    public void fetchThreadInfo(String tid) {
        invoke(service.fetchThreadInfo(tid), new Callback<BaseResponse2>() {
            @Override
            public void onResponse(BaseResponse2 data) {
                mView.showThreadInfo(data);
            }
        });
    }

    @Override
    public void fetchCheckPost() {
        invoke(service.fetchCheckPost(), new Callback<BaseResponse2>() {
            @Override
            public void onResponse(BaseResponse2 data) {
                mView.showCheckPost(data);
            }
        });
    }


//
//    @Override
//    public void fetchGetAll(String fid, String page) {
//        invoke(service.fetchGetAll(fid,page),new Callback<BaseResponse2<GetAllResult>>(){
//            @Override
//            public void onResponse(BaseResponse2<GetAllResult> data) {
//                mView.showGetAll(data);
//            }
//        });
//    }
//
//    @Override
//    public void fetchThemeList(String fid, String page) {
//        invoke(service.fetchThemeList(fid,page),new Callback<BaseResponse2<ThemeListResult>>(){
//            @Override
//            public void onResponse(BaseResponse2<ThemeListResult> data) {
//                mView.showThemeList(data);
//            }
//        });
//    }
}
