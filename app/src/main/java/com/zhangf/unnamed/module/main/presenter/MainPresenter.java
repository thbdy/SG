package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;

public class MainPresenter {
    interface Presenter{
        void fetchGetAll( String fid, String page);
        void fetchThemeList( String fid, String page);
    }
    public interface View extends BaseView {
        void showGetAll(BaseResponse2<GetAllResult> result);
        void showThemeList(BaseResponse2<ThemeListResult> result);

    }
}
