package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.SignResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;

public class ForumPresenter {
    interface Presenter{
        void fetchGetAll( String fid, String page);
        void fetchThemeList( String fid, String page);
        void fetchSign(String token,String formhash);

    }
    public interface View extends BaseView {
        void showGetAll(BaseResponse2<GetAllResult> result);
        void showThemeList(BaseResponse2<ThemeListResult> result);
        void showSign(SignResult result);
    }
}
