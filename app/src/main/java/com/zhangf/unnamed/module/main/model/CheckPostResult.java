package com.zhangf.unnamed.module.main.model;

public class CheckPostResult {

    /**
     * cookiepre : U6IV_2132_
     * auth : 51c3yCNYwPfxvOBGpw4C5edgp9miUnPAEq7CxHVlTY9ZfM6mT+uJunxY8gD/mXuDy4C+e1cSy+lmOopOZdUljVzV59Ka
     * saltkey : hZddehML
     * member_uid : 8793833
     * member_username : thbdy
     * groupid : 13
     * formhash : 9eedff07
     * ismoderator : null
     * readaccess : 30
     * notice : {"newpush":"0","newpm":"0","newprompt":"0","newmypost":"0"}
     * allowperm : {"allowpost":"0","allowreply":"0","allowupload":{"jpg":"-1","jpeg":"-1","gif":"-1","png":"-1","mp3":"10240000","txt":"1024000","zip":"4294967295","rar":"102400000","pdf":"-1"},"attachremain":{"size":"25600000","count":"-1"},"uploadhash":"423c1f8420dd1bf313fbc0ebf60de610"}
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
    private AllowpermBean allowperm;

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

    public AllowpermBean getAllowperm() {
        return allowperm;
    }

    public void setAllowperm(AllowpermBean allowperm) {
        this.allowperm = allowperm;
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

    public static class AllowpermBean {
        /**
         * allowpost : 0
         * allowreply : 0
         * allowupload : {"jpg":"-1","jpeg":"-1","gif":"-1","png":"-1","mp3":"10240000","txt":"1024000","zip":"4294967295","rar":"102400000","pdf":"-1"}
         * attachremain : {"size":"25600000","count":"-1"}
         * uploadhash : 423c1f8420dd1bf313fbc0ebf60de610
         */

        private String allowpost;
        private String allowreply;
        private AllowuploadBean allowupload;
        private AttachremainBean attachremain;
        private String uploadhash;

        public String getAllowpost() {
            return allowpost;
        }

        public void setAllowpost(String allowpost) {
            this.allowpost = allowpost;
        }

        public String getAllowreply() {
            return allowreply;
        }

        public void setAllowreply(String allowreply) {
            this.allowreply = allowreply;
        }

        public AllowuploadBean getAllowupload() {
            return allowupload;
        }

        public void setAllowupload(AllowuploadBean allowupload) {
            this.allowupload = allowupload;
        }

        public AttachremainBean getAttachremain() {
            return attachremain;
        }

        public void setAttachremain(AttachremainBean attachremain) {
            this.attachremain = attachremain;
        }

        public String getUploadhash() {
            return uploadhash;
        }

        public void setUploadhash(String uploadhash) {
            this.uploadhash = uploadhash;
        }

        public static class AllowuploadBean {
            /**
             * jpg : -1
             * jpeg : -1
             * gif : -1
             * png : -1
             * mp3 : 10240000
             * txt : 1024000
             * zip : 4294967295
             * rar : 102400000
             * pdf : -1
             */

            private String jpg;
            private String jpeg;
            private String gif;
            private String png;
            private String mp3;
            private String txt;
            private String zip;
            private String rar;
            private String pdf;

            public String getJpg() {
                return jpg;
            }

            public void setJpg(String jpg) {
                this.jpg = jpg;
            }

            public String getJpeg() {
                return jpeg;
            }

            public void setJpeg(String jpeg) {
                this.jpeg = jpeg;
            }

            public String getGif() {
                return gif;
            }

            public void setGif(String gif) {
                this.gif = gif;
            }

            public String getPng() {
                return png;
            }

            public void setPng(String png) {
                this.png = png;
            }

            public String getMp3() {
                return mp3;
            }

            public void setMp3(String mp3) {
                this.mp3 = mp3;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public String getRar() {
                return rar;
            }

            public void setRar(String rar) {
                this.rar = rar;
            }

            public String getPdf() {
                return pdf;
            }

            public void setPdf(String pdf) {
                this.pdf = pdf;
            }
        }

        public static class AttachremainBean {
            /**
             * size : 25600000
             * count : -1
             */

            private String size;
            private String count;

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }
        }
    }
}
