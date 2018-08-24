package com.zhangf.unnamed.module.main.model;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class SendMessageResult {


    /**
     * Version : 1
     * Charset : UTF-8
     * Variables : {"cookiepre":"U6IV_2132_","auth":"3d4dUet6H4qXuNEQtBgwDX3APchoIKKczMJ9pqOniWZEXLGr0lHNAaLJwvJimzP+jemDlTnGes7plEbXTEQp9uksIo88","saltkey":"aCJ7H8h7","member_uid":"9088080","member_username":"潇洒哥666","groupid":"11","formhash":"168f8289","ismoderator":null,"readaccess":"10","notice":{"newpush":"0","newpm":"0","newprompt":"8","newmypost":"0"},"pmid":"250846"}
     * Message : {"messageval":"do_success","messagestr":"操作成功 "}
     */

    private String Version;
    private String Charset;
    private VariablesBean Variables;
    private MessageBean Message;

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }

    public String getCharset() {
        return Charset;
    }

    public void setCharset(String Charset) {
        this.Charset = Charset;
    }

    public VariablesBean getVariables() {
        return Variables;
    }

    public void setVariables(VariablesBean Variables) {
        this.Variables = Variables;
    }

    public MessageBean getMessage() {
        return Message;
    }

    public void setMessage(MessageBean Message) {
        this.Message = Message;
    }

    public static class VariablesBean {
        /**
         * cookiepre : U6IV_2132_
         * auth : 3d4dUet6H4qXuNEQtBgwDX3APchoIKKczMJ9pqOniWZEXLGr0lHNAaLJwvJimzP+jemDlTnGes7plEbXTEQp9uksIo88
         * saltkey : aCJ7H8h7
         * member_uid : 9088080
         * member_username : 潇洒哥666
         * groupid : 11
         * formhash : 168f8289
         * ismoderator : null
         * readaccess : 10
         * notice : {"newpush":"0","newpm":"0","newprompt":"8","newmypost":"0"}
         * pmid : 250846
         */

        private String cookiepre;
        private String auth;
        private String saltkey;
        private String member_uid;
        private String member_username;
        private String groupid;
        private String formhash;
        private Object ismoderator;
        private String readaccess;
        private NoticeBean notice;
        private String pmid;

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

        public String getPmid() {
            return pmid;
        }

        public void setPmid(String pmid) {
            this.pmid = pmid;
        }

        public static class NoticeBean {
            /**
             * newpush : 0
             * newpm : 0
             * newprompt : 8
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

    public static class MessageBean {
        /**
         * messageval : do_success
         * messagestr : 操作成功
         */

        private String messageval;
        private String messagestr;

        public String getMessageval() {
            return messageval;
        }

        public void setMessageval(String messageval) {
            this.messageval = messageval;
        }

        public String getMessagestr() {
            return messagestr;
        }

        public void setMessagestr(String messagestr) {
            this.messagestr = messagestr;
        }
    }
}
