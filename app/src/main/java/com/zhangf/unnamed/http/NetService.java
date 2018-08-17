package com.zhangf.unnamed.http;


public interface NetService {
////153f73bf1a9039aa25214784346175cb9fc2855243_______b749582e27865232a912de14151ff60c
//    String BASE_URL = "https://passport1.sgamer.com/";
//
//    String BASE_URL2 = "https://bbs.sgamer.com/api/mobile/";
//
//    String BASE_URL3 = "https://betapi.sgamer.com/";
//
//
//    //登录
//    @FormUrlEncoded
//    @POST("index.php?m=App&a=login")
//    Observable<BaseResponse<String>> fetchLoginInfo(@Field("type") String type, @Field("apiToken")String token, @Field("username")String username,
//                                            @Field("password")String password);
//
////    dota2 44
//    @FormUrlEncoded
//    @POST("iyz_index.php?module=forumindex&version=1")
//    Observable<BaseResponse2<GetAllResult>> fetchGetAll(@Field("fid") String fid, @Field("page")String page);
//
//
//    /**
//     * 获取主题列表
//     * @param fid
//     * @param page
//     * @return
//     */
//    @POST("iyz_index.php?module=forumdisplay&version=1")
//    Observable<BaseResponse2<ThemeListResult>> fetchThemeList(@Query("fid") String fid, @Query("page")String page);
//
//    /**
//     * 获取帖子详情
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php?module=viewthread&version=4")
//    Observable<BaseResponse2> fetchThreadInfo(@Field("tid") String tid);
//
//    /**
//     * 获取权限
//     * @return
//     */
//    @GET("iyz_index.php?version=1&module=checkpost")
//    Observable<BaseResponse2<CheckPostResult>> fetchCheckPost();
//
//    //ed1cpK25Jdkn0BHbIDgv336%2FVCHXRvHm32GxuQ7%2FGAl990|X%2FBnhw8Rtx1MszNT23UaC77E8Cz%2F9BaU6lpBsOxrYsRKgb%2BIwScpprH%2BW%2BCzqHEjHoFIpk7G5Lnn6p2lD9U6HMA00SSzMxNNpuNeBEVSHAUi0GbxFyZ3qzht2maZjt
//    //d6fcdeHSGtJtPrRhS63lpgJT04OD88RagdW618%2BINMTEV77OOTKIqtDATrYw9cHTbC9mm6GrsTBvp6OCMYsThWpbH6TSU0YW9ZEXPkLuIJRqUWr1MSdoD41kOOAxI14DF8%2FQaQ7gijk88c6szZTFJODo50DshNEoA93SPIiPA8kl
//    /**
//     * 获取用户信息
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php?g=app&m=user&a=getuserinfo")
//    Observable<UserInfoResult> fetchUserInfo(@Field("token") String token,@Field("apiToken") String apiToken);
//
//
//
//// type=3&username=752323877%40qq.com&password=dudjdjje&apiToken=153f73bf1a9039aa25211884346175cb9fc2854317
//
//
////    static
////    {
////        register = "m=App&a=reg";
////        login = "m=App&a=login";
////        getUserInfo = "https://betapi.sgamer.com/index.php?g=app&m=user&a=getuserinfo";
////        sendcode = "m=Sms&a=send";
////        checkcode = "m=Sms&a=verify";
////        forgetpassword = "https://passport1.sgamer.com/index.php?m=App&a=resetpass";
////        woodDeatils = "https://betapi.sgamer.com/index.php?g=app&m=user&a=record";
////        myGuess = "https://betapi.sgamer.com/index.php?g=app&m=user&a=myGuess";
////        upaddress = "https://betapi.sgamer.com/index.php?g=app&m=user&a=upaddress";
////        editpass = "https://passport1.sgamer.com/index.php?m=App&a=editpass";
////        upload = "https://u.sgamer.com/uc_server/upload.php";
////        notification = "https://betapi.sgamer.com/index.php?g=app&m=extra&a=notification";
////        myFoucsMatch = "https://betapi.sgamer.com/index.php?g=app&m=favorite&a=get";
////        getInfo = "https://betapi.sgamer.com/index.php?g=app&m=bet&a=getInfo";
////        add = "https://betapi.sgamer.com/index.php?g=app&m=favorite&a=add";
////        del = "https://betapi.sgamer.com/index.php?g=app&m=favorite&a=del";
////        guess = "https://betapi.sgamer.com/index.php?g=app&m=bet&a=guess";
////        gettagnews = "https://appapi.sgamer.com/index.php?m=news&a=gettagnews";
////        addComment = "https://appapi.sgamer.com/index.php?m=news&a=addcomment";
////        getcommentnum = "https://appapi.sgamer.com/index.php?m=news&a=getcommentnum";
////        getlist = "https://betapi.sgamer.com/index.php?g=app&m=exchange&a=getlist";
////        getgift = "https://betapi.sgamer.com/index.php?g=app&m=exchange&a=getInfo";
////        deal = "https://betapi.sgamer.com/index.php?g=app&m=exchange&a=deal";
////        getMore = "https://betapi.sgamer.com/index.php?g=app&m=exchange&a=get";
////        myExchange = "https://betapi.sgamer.com/index.php?g=app&m=exchange&a=myExchange";
////        myExchangeInfo = "https://betapi.sgamer.com/index.php?g=app&m=exchange&a=myExchangeInfo";
////        getToady = "https://betapi.sgamer.com/index.php?g=app&m=top&a=getToady";
////        getChampion = "https://betapi.sgamer.com/index.php?g=app&m=champion&a=getChampion";
////        getEasy = "https://betapi.sgamer.com/index.php?g=app&m=easy&a=getEasy";
////        guessEasy = "https://betapi.sgamer.com/index.php?g=app&m=easy&a=guessEasy";
////        getranking = "https://betapi.sgamer.com/index.php?g=app&m=rank&a=get";
////        taskRecord = "https://betapi.sgamer.com/index.php?g=app&m=user&a=taskRecord";
////        sign = "https://betapi.sgamer.com/index.php?g=app&m=user&a=sign";
////        signfourm = "https://bbs.sgamer.com/plugin.php?id=dsu_paulsign:sign&operation=qiandao&infloat=0&inajax=1";
////        getCharg = "https://betapi.sgamer.com/index.php?g=app&m=user&a=getCharg";
////        getChampionInfo = "https://betapi.sgamer.com/index.php?g=app&m=champion&a=getInfo";
////        guessChampion = "https://betapi.sgamer.com/index.php?g=app&m=champion&a=guessChampion";
////        getappnews = "http://www.sgamer.com/index.php?m=Api&a=getappnews";
////        getall = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=forumindex&version=1";
////        hotPost = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=hotthread&version=1";
////        addshare = "https://appapi.sgamer.com/index.php?m=news&a=addshare";
////        getThemeList = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=forumdisplay&version=1";
////        getPostList = "https://bbs.sgamer.com/api/mobile/index.php?module=viewthread&version=4";
////        publishVote = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=newthread&version=1&topicsubmit=yes";
////        publishPost = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=newthread&version=1&topicsubmit=yes";
////        replyPost = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=sendreply&version=1&replysubmit=yes&infloat=yes&handlekey=fastpost";
////        myPost = "https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=mythread&type=threadcharset=utf-8&ac=thread";
////        myReply = "https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=mythread&type=reply&charset=utf-8&ac=reply";
////        getAdv = "https://betapi.sgamer.com/index.php?g=app&m=extra&a=getAdv";
////        forumReport = "https://bbs.sgamer.com/api/mobile/iyz_index.php?version=4&do=support&module=report";
////        bindconnect = "https://passport1.sgamer.com/index.php?m=App&a=bindconnect";
////        bindstatus = "https://passport1.sgamer.com/index.php?m=App&a=bindstatus";
////        getmatchvideo = "https://betapi.sgamer.com/index.php?g=app&m=bet&a=getmatchvideo";
////        froumsign = "https://bbs.sgamer.com/plugin.php?id=dsu_paulsign:sign&operation=qiandao&infloat=0&inajax=1&api=sign";
////        myFriend = "https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=friend&charset=utf-8";
////        searchuser = "https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=searchuser&version=4";
////        findfriend = "https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=findfriend&version=4";
////        checknewpm = "https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=checknewpm&version=4";
////        newfriend = "https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=newfriend&only_count=0&version=4";
////        auditfriend = "https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=auditfriend&version=4&check=1";
////        canfriend = "https://bbs.sgamer.com/api/mobile/iyz_index.php?check=1&iyzmobile=1&module=addfriend&version=4";
////        friendInfo = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=profile&version=4";
////        addfriend = "https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=addfriend&version=4";
////        deletefriend = "https://bbs.sgamer.com/api/mobile/iyz_index.php?version=4&iyzmobile=1&module=removefriend";
////        mypm = "https://bbs.sgamer.com/api/mobile/iyz_index.php?module=mypm&version=4";
////        allMessage = "https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=mypm&charset=utf-8&subop=view";
////        sendMessage = "https://bbs.sgamer.com/api/mobile/index.php?mobile=no&version=4&module=sendpm&pmsubmit=yes&charset=utf-8";
////        sixin = "https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=mypm&charset=utf-8";
////    }
}
