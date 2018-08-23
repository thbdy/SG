package com.zhangf.unnamed.module.menu.model;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class AddFriendResult {

    /**
     * cookiepre : U6IV_2132_
     * auth : 6e90KTh1AOSzXFxe4M8EFzg5vOmLFfUfnM2sRo5hYE0TRCx689x4uYexQLHF/po7Bv648924M5LqyJGg3Zd/vvFFanG+
     * saltkey : HcSumTTt
     * member_uid : 8793833
     * member_username : thbdy
     * member_avatar : http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg
     * groupid : 13
     * formhash : 90e7acde
     * ismoderator : null
     * readaccess : 30
     * notice : {"newpush":"0","newpm":"0","newprompt":"0","newmypost":"0"}
     * status : 0
     * messageval : request_has_been_sent
     * show_message : 好友请求已发送，请等待对方验证
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
    private String status;
    private String messageval;
    private String show_message;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageval() {
        return messageval;
    }

    public void setMessageval(String messageval) {
        this.messageval = messageval;
    }

    public String getShow_message() {
        return show_message;
    }

    public void setShow_message(String show_message) {
        this.show_message = show_message;
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
}
