package com.zhangf.unnamed.module.menu.presenter;

import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.base.BaseView;

public class SearchPresenter {
    interface Presenter{
        void fetchSearch(String formhash,String srchtxt,String searchsubmit);


    }
    public interface View extends BaseView {
        void showSearch(BaseResponse result);

    }
}
