package com.zhangf.unnamed.module.menu.model;

import java.util.List;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class MyFriendsResult {

    /**
     * cookiepre : U6IV_2132_
     * auth : 8300zoEbZjhNPNhTQj0CD88EYRjb7IaW8NlXRFRrh5wP8L0QAsSt0nt8G1OiYIXXagrTCkGxeDyK1OCSEAhbXnMhYdwu
     * saltkey : HhPhAHQe
     * member_uid : 8793833
     * member_username : thbdy
     * member_avatar : http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg
     * groupid : 13
     * formhash : 062bac68
     * ismoderator : null
     * readaccess : 30
     * notice : {"newpush":"0","newpm":"0","newprompt":"0","newmypost":"0"}
     * count : 2
     * list : [{"uid":"9088080","gid":"1","username":"潇洒哥666","adminid":"0","groupid":"11","groupname":"LV1","avatar":"http://u.sgamer.com/uc_server/data/avatar/009/08/80/80_avatar_big.jpg"},{"uid":"9088150","gid":"1","username":"Lucky_E","adminid":"0","groupid":"12","groupname":"LV2","avatar":"http://u.sgamer.com/uc_server/data/avatar/009/08/81/50_avatar_big.jpg"}]
     */

    private String cookiepre;
    private String auth;
    private String saltkey;
    private String member_uid;
    private String member_username;
    private String member_avatar;
    private String groupid;
    private String formhash;
    private Object ismoderator;
    private String readaccess;
    private NoticeBean notice;
    private String count;
    private List<ListBean> list;

    public String getCookiepre() {
        return cookiepre;
    }

    public void setCookiepre(String cookiepre) {
        this.cookiepre = cookiepre;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getSaltkey() {
        return saltkey;
    }

    public void setSaltkey(String saltkey) {
        this.saltkey = saltkey;
    }

    public String getMember_uid() {
        return member_uid;
    }

    public void setMember_uid(String member_uid) {
        this.member_uid = member_uid;
    }

    public String getMember_username() {
        return member_username;
    }

    public void setMember_username(String member_username) {
        this.member_username = member_username;
    }

    public String getMember_avatar() {
        return member_avatar;
    }

    public void setMember_avatar(String member_avatar) {
        this.member_avatar = member_avatar;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getFormhash() {
        return formhash;
    }

    public void setFormhash(String formhash) {
        this.formhash = formhash;
    }

    public Object getIsmoderator() {
        return ismoderator;
    }

    public void setIsmoderator(Object ismoderator) {
        this.ismoderator = ismoderator;
    }

    public String getReadaccess() {
        return readaccess;
    }

    public void setReadaccess(String readaccess) {
        this.readaccess = readaccess;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class NoticeBean {
        /**
         * newpush : 0
         * newpm : 0
         * newprompt : 0
         * newmypost : 0
         */

        private String newpush;
        private String newpm;
        private String newprompt;
        private String newmypost;

        public String getNewpush() {
            return newpush;
        }

        public void setNewpush(String newpush) {
            this.newpush = newpush;
        }

        public String getNewpm() {
            return newpm;
        }

        public void setNewpm(String newpm) {
            this.newpm = newpm;
        }

        public String getNewprompt() {
            return newprompt;
        }

        public void setNewprompt(String newprompt) {
            this.newprompt = newprompt;
        }

        public String getNewmypost() {
            return newmypost;
        }

        public void setNewmypost(String newmypost) {
            this.newmypost = newmypost;
        }
    }

    public static class ListBean {
        /**
         * uid : 9088080
         * gid : 1
         * username : 潇洒哥666
         * adminid : 0
         * groupid : 11
         * groupname : LV1
         * avatar : http://u.sgamer.com/uc_server/data/avatar/009/08/80/80_avatar_big.jpg
         */

        private String uid;
        private String gid;
        private String username;
        private String adminid;
        private String groupid;
        private String groupname;
        private String avatar;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAdminid() {
            return adminid;
        }

        public void setAdminid(String adminid) {
            this.adminid = adminid;
        }

        public String getGroupid() {
            return groupid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public String getGroupname() {
            return groupname;
        }

        public void setGroupname(String groupname) {
            this.groupname = groupname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
