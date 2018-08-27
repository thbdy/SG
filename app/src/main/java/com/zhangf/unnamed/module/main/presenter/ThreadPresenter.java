package com.zhangf.unnamed.module.main.presenter;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseView;
import com.zhangf.unnamed.module.main.model.CheckPostResult;

import retrofit2.http.Field;
import retrofit2.http.Query;

public class ThreadPresenter {
    interface Presenter{
        void fetchThreadInfo(String tid);
        void fetchCheckPost(@Query("mod") String mod,
                            @Query("action")String action,
                            @Query("fid")String fid,
                            @Query("tid")String tid,
                            @Query("extra")String extra,
                            @Query("replysubmit")String replysubmit,
                            @Query("infloat")String infloat,
                            @Query("handlekey")String handlekey,
                            @Query("inajax")String inajax,
                            @Field("message") String message,
                            @Field("posttime") String posttime,
                            @Field("formhash") String formhash,
                            @Field("usesig") String usesig,
                            @Field("subject") String subject);

        void fetchReply();
    }
    public interface View extends BaseView {
        void showThreadInfo(BaseResponse2 result);
        void showCheckPost(BaseResponse2<CheckPostResult> result);
        void showReply(String result);
    }
}
