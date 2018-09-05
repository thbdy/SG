package com.zhangf.unnamed.module.main.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zhangf.unnamed.UserInfoManager;

import java.util.List;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class ChatResult {
    /**
     * cookiepre : U6IV_2132_
     * auth : a7e4aproFWd7vusSHDUfrb+DU4rsFeFEDhEjlwIq0kcZdKqsGniYYO7euxJ8AR2jpvOoG3GzTwazqHeLoe9N28XByun3
     * saltkey : U59q32K3
     * member_uid : 8793833
     * member_username : thbdy
     * member_avatar : http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg
     * groupid : 13
     * formhash : 19ebf1ce
     * ismoderator : null
     * readaccess : 30
     * notice : {"newpush":"0","newpm":"0","newprompt":"0","newmypost":"0"}
     * list : [{"plid":"81855","authorid":"9088080","pmtype":"1","subject":"在吗","members":"2","dateline":"1534937414","pmid":"250800","message":"在吗","touid":"8793833","author":"潇洒哥666","msgfromid":"9088080","msgfrom":"潇洒哥666","msgtoid":"8793833","msgtoid_avatar":"http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg","msgfromid_avatar":"http://u.sgamer.com/uc_server/data/avatar/009/08/80/80_avatar_big.jpg"},{"plid":"81855","authorid":"9088080","pmtype":"1","subject":"在吗","members":"2","dateline":"1535012072","pmid":"250838","message":"你好吗","touid":"8793833","author":"潇洒哥666","msgfromid":"9088080","msgfrom":"潇洒哥666","msgtoid":"8793833","msgtoid_avatar":"http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg","msgfromid_avatar":"http://u.sgamer.com/uc_server/data/avatar/009/08/80/80_avatar_big.jpg"},{"plid":"81855","authorid":"8793833","pmtype":"1","subject":"在吗","members":"2","dateline":"1535012109","pmid":"250839","message":"还不错","touid":"9088080","author":"thbdy","msgfromid":"8793833","msgfrom":"thbdy","msgtoid":"9088080","msgtoid_avatar":"http://u.sgamer.com/uc_server/data/avatar/009/08/80/80_avatar_big.jpg","msgfromid_avatar":"http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg"}]
     * count : 3
     * perpage : 5
     * page : 1
     * need_more : 0
     * pmid : 250800
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
    private String perpage;
    private String page;
    private String need_more;
    private String pmid;
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

    public String getPerpage() {
        return perpage;
    }

    public void setPerpage(String perpage) {
        this.perpage = perpage;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getNeed_more() {
        return need_more;
    }

    public void setNeed_more(String need_more) {
        this.need_more = need_more;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
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

    public static class ListBean implements MultiItemEntity {
        public static final int TYPE_1 = 1;
        public static final int TYPE_2 = 2;
        /**
         * plid : 81855
         * authorid : 9088080
         * pmtype : 1
         * subject : 在吗
         * members : 2
         * dateline : 1534937414
         * pmid : 250800
         * message : 在吗
         * touid : 8793833
         * author : 潇洒哥666
         * msgfromid : 9088080
         * msgfrom : 潇洒哥666
         * msgtoid : 8793833
         * msgtoid_avatar : http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg
         * msgfromid_avatar : http://u.sgamer.com/uc_server/data/avatar/009/08/80/80_avatar_big.jpg
         */

        private String plid;
        private String authorid;
        private String pmtype;
        private String subject;
        private String members;
        private String dateline;
        private String pmid;
        private String message;
        private String touid;
        private String author;
        private String msgfromid;
        private String msgfrom;
        private String msgtoid;
        private String msgtoid_avatar;
        private String msgfromid_avatar;

        public String getPlid() {
            return plid;
        }

        public void setPlid(String plid) {
            this.plid = plid;
        }

        public String getAuthorid() {
            return authorid;
        }

        public void setAuthorid(String authorid) {
            this.authorid = authorid;
        }

        public String getPmtype() {
            return pmtype;
        }

        public void setPmtype(String pmtype) {
            this.pmtype = pmtype;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getMembers() {
            return members;
        }

        public void setMembers(String members) {
            this.members = members;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getPmid() {
            return pmid;
        }

        public void setPmid(String pmid) {
            this.pmid = pmid;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTouid() {
            return touid;
        }

        public void setTouid(String touid) {
            this.touid = touid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getMsgfromid() {
            return msgfromid;
        }

        public void setMsgfromid(String msgfromid) {
            this.msgfromid = msgfromid;
        }

        public String getMsgfrom() {
            return msgfrom;
        }

        public void setMsgfrom(String msgfrom) {
            this.msgfrom = msgfrom;
        }

        public String getMsgtoid() {
            return msgtoid;
        }

        public void setMsgtoid(String msgtoid) {
            this.msgtoid = msgtoid;
        }

        public String getMsgtoid_avatar() {
            return msgtoid_avatar;
        }

        public void setMsgtoid_avatar(String msgtoid_avatar) {
            this.msgtoid_avatar = msgtoid_avatar;
        }

        public String getMsgfromid_avatar() {
            return msgfromid_avatar;
        }

        public void setMsgfromid_avatar(String msgfromid_avatar) {
            this.msgfromid_avatar = msgfromid_avatar;
        }

        @Override
        public int getItemType() {
            return authorid.equals(UserInfoManager.getUserInfoManager().getUcid())? TYPE_1:TYPE_2;
        }
    }
}
