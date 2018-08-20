package com.zhangf.unnamed.module.menu.model;

import java.util.List;

/**
 * Created by 75232 on 2018/8/20
 * Email：752323877@qq.com
 */
public class PrivateLetterResult {
    /**
     * cookiepre : U6IV_2132_
     * auth : 9965oAiyrgnWGRqBPpOQBA1dq2+37uRqBZjFZJwPjqe2MP/cknDbs5xC3sAzI1y+vDVQxndcLwQObLjGv54laVro5icm
     * saltkey : O7OYFfBs
     * member_uid : 8793833
     * member_username : thbdy
     * member_avatar : http://u.sgamer.com/uc_server/data/avatar/008/79/38/33_avatar_big.jpg
     * groupid : 13
     * formhash : 8cfbca69
     * ismoderator : null
     * readaccess : 30
     * notice : {"newpush":"0","newpm":"0","newprompt":"0","newmypost":"0"}
     * list : [{"plid":"73992","isnew":"0","pmnum":"1","lastupdate":"0","lastdateline":"1520472873","authorid":"614760","pmtype":"1","subject":"抬一手啊&nbsp; &nbsp;91那个怎么弄啊","members":"2","dateline":"1520472873","touid":"614760","pmid":"73992","lastauthorid":"614760","lastauthor":"1647158861","lastsummary":"抬一手啊 91那个怎么弄啊","msgfromid":"614760","msgfrom":"1647158861","message":"抬一手啊   91那个怎么弄啊","msgtoid":"614760","tousername":"1647158861","msgtoid_avatar":"http://u.sgamer.com/uc_server/data/avatar/000/61/47/60_avatar_big.jpg","msgfromid_avatar":"http://u.sgamer.com/uc_server/data/avatar/000/61/47/60_avatar_big.jpg"}]
     * count  : 25
     * perpage  : 15
     * page  : 1
     * need_more  : 1
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
         * plid : 73992
         * isnew : 0
         * pmnum : 1
         * lastupdate : 0
         * lastdateline : 1520472873
         * authorid : 614760
         * pmtype : 1
         * subject : 抬一手啊&nbsp; &nbsp;91那个怎么弄啊
         * members : 2
         * dateline : 1520472873
         * touid : 614760
         * pmid : 73992
         * lastauthorid : 614760
         * lastauthor : 1647158861
         * lastsummary : 抬一手啊 91那个怎么弄啊
         * msgfromid : 614760
         * msgfrom : 1647158861
         * message : 抬一手啊   91那个怎么弄啊
         * msgtoid : 614760
         * tousername : 1647158861
         * msgtoid_avatar : http://u.sgamer.com/uc_server/data/avatar/000/61/47/60_avatar_big.jpg
         * msgfromid_avatar : http://u.sgamer.com/uc_server/data/avatar/000/61/47/60_avatar_big.jpg
         */

        private String plid;
        private String isnew;
        private String pmnum;
        private String lastupdate;
        private String lastdateline;
        private String authorid;
        private String pmtype;
        private String subject;
        private String members;
        private String dateline;
        private String touid;
        private String pmid;
        private String lastauthorid;
        private String lastauthor;
        private String lastsummary;
        private String msgfromid;
        private String msgfrom;
        private String message;
        private String msgtoid;
        private String tousername;
        private String msgtoid_avatar;
        private String msgfromid_avatar;

        public String getPlid() {
            return plid;
        }

        public void setPlid(String plid) {
            this.plid = plid;
        }

        public String getIsnew() {
            return isnew;
        }

        public void setIsnew(String isnew) {
            this.isnew = isnew;
        }

        public String getPmnum() {
            return pmnum;
        }

        public void setPmnum(String pmnum) {
            this.pmnum = pmnum;
        }

        public String getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(String lastupdate) {
            this.lastupdate = lastupdate;
        }

        public String getLastdateline() {
            return lastdateline;
        }

        public void setLastdateline(String lastdateline) {
            this.lastdateline = lastdateline;
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

        public String getTouid() {
            return touid;
        }

        public void setTouid(String touid) {
            this.touid = touid;
        }

        public String getPmid() {
            return pmid;
        }

        public void setPmid(String pmid) {
            this.pmid = pmid;
        }

        public String getLastauthorid() {
            return lastauthorid;
        }

        public void setLastauthorid(String lastauthorid) {
            this.lastauthorid = lastauthorid;
        }

        public String getLastauthor() {
            return lastauthor;
        }

        public void setLastauthor(String lastauthor) {
            this.lastauthor = lastauthor;
        }

        public String getLastsummary() {
            return lastsummary;
        }

        public void setLastsummary(String lastsummary) {
            this.lastsummary = lastsummary;
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

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMsgtoid() {
            return msgtoid;
        }

        public void setMsgtoid(String msgtoid) {
            this.msgtoid = msgtoid;
        }

        public String getTousername() {
            return tousername;
        }

        public void setTousername(String tousername) {
            this.tousername = tousername;
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
    }
}
