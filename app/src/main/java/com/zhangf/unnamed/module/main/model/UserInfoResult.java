package com.zhangf.unnamed.module.main.model;

/**
 * Created by 75232 on 2018/8/17
 * Email：zhangfu@ylzinfo.com
 */
public class UserInfoResult {
    @Override
    public String toString() {
        return "UserInfoResult{" +
                "uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gold=" + gold +
                ", phone='" + phone + '\'' +
                ", ucid='" + ucid + '\'' +
                '}';
    }

    /**
     * uid : 1305416
     * token : 4fc6349986da5a2b34ba7835954c59a9
     * nickname : thbdy
     * gold : 668
     * phone : 18350863178
     * ucid : 8793833
     */

    private String uid;
    private String token;
    private String nickname;
    private int gold;
    private String phone;
    private String ucid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
}
