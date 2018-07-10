package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.http.NetService;
import com.zhangf.unnamed.http.utils.Callback;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;

import javax.inject.Inject;

public class MainPresenterImpl extends BasePresenter<MainPresenter.View> implements MainPresenter.Presenter{
    NetService service;
    @Inject
    public MainPresenterImpl(NetService service){
        this.service = service;
    }



    @Override
    public void fetchGetAll(String fid, String page) {
        invoke(service.fetchGetAll(fid,page),new Callback<BaseResponse2<GetAllResult>>(){
            @Override
            public void onResponse(BaseResponse2<GetAllResult> data) {
                mView.showGetAll(data);
            }
        });
    }

    @Override
    public void fetchThemeList(String fid, String page) {
        invoke(service.fetchThemeList(fid,page),new Callback<BaseResponse2<ThemeListResult>>(){
            @Override
            public void onResponse(BaseResponse2<ThemeListResult> data) {
                mView.showThemeList(data);
            }
        });
    }
}
