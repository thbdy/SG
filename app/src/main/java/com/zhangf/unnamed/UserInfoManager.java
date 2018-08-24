package com.zhangf.unnamed;

import com.google.gson.Gson;
import com.zhangf.unnamed.module.main.model.UserInfoResult;
import com.zhangf.unnamed.utils.SPUtils;

/**
 * 用户信息管理类
 */
public class UserInfoManager {
    private static String SP_KEY = "user_data";
    private static UserInfoManager userInfoManager;

    private Boolean login;
    private String token;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUcid() {
        return ucid;
    }

    public void setUcid(String ucid) {
        this.ucid = ucid;
    }

    private String nickname;
    private String uid;
    private int gold;
    private String phone;
    private String ucid;

    public void setUserData(String  info) {
        SPUtils.put(App.getApp(),SP_KEY,info);
        UserInfoResult userInfoResult = new Gson().fromJson(info,UserInfoResult.class);
        this.token = userInfoResult.getToken();
        this.nickname = userInfoResult.getNickname();
        this.uid = userInfoResult.getUid();
        this.gold = userInfoResult.getGold();
        this.phone = userInfoResult.getPhone();
        this.ucid = userInfoResult.getUcid();
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
