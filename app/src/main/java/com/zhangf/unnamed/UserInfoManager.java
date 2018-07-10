package com.zhangf.unnamed;

import com.zhangf.unnamed.utils.SPUtils;

public class UserInfoManager {
    private static String SP_KEY = "user_data";


    private static UserInfoManager userInfoManager;

    private Boolean login;

    public void setUserData(String  info) {
        SPUtils.put(App.getApp(),SP_KEY,info);
    }









    public static UserInfoManager getUserInfoManager() {
        if(userInfoManager == null){
            userInfoManager = new UserInfoManager();
            if(SPUtils.get(App.getApp(),SP_KEY,"") != null
                    && !SPUtils.get(App.getApp(),SP_KEY,"").equals("")){
                UserInfoManager.getUserInfoManager().setUserData((String) SPUtils.get(App.getApp(),SP_KEY,""));
            }
        }
        return userInfoManager;
    }

    public static void setUserInfoManager(UserInfoManager userInfoManager) {
        UserInfoManager.userInfoManager = userInfoManager;
    }
    /**
     * 销毁
     */
    public void destroy() {
        if (userInfoManager != null) {
            userInfoManager = null;
        }
        SPUtils.remove(App.getApp(),SP_KEY);

    }

    public Boolean getLogin() {
        if(login == null){
            login = (Boolean) SPUtils.get(App.getApp(),"login_state",false);
        }
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
        SPUtils.put(App.getApp(),"login_state",true);
    }
}
