package com.zhangf.unnamed.module.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class ProFileResult {

    /**
     * cookiepre : U6IV_2132_
     * auth : c4d5q9HShb2uIRjm2lUrtBu2aFSpQKYhv7m+O98gQGHk5yxXqAwxemCbt4Ya3BrJydhVWSrWUFXseRfh5aNFw+N3Ki7A
     * saltkey : M385qZaT
     * member_uid : 8793833
     * member_username : thbdy
     * groupid : 13
     * formhash : 199cac1e
     * ismoderator : null
     * readaccess : 30
     * notice : {"newpush":"0","newpm":"0","newprompt":"1","newmypost":"0"}
     * space : {"uid":"8619674","username":"呵呵不能死","regdate":"2014-3-24 15:11","credits":"4584","friends":"22","posts":"1716","threads":"675","feedfriend":"8465189,8518613,8836832,8793447,8969982,8567180,8867417,8629300,8536468,8441282,600844,8756238,8479676,8618563,8517556,338078,8728136,624369,8629606,8778784,8538033,8527416","gender":"0","group":{"grouptitle":"LV7"},"avatar":"http://u.sgamer.com/uc_server/data/avatar/008/61/96/74_avatar_big.jpg","self":"","extcredits":[{"value":"6939","name":"金币"},{"value":"3966","name":"荣誉"},{"value":"0","name":"超丸"},{"value":"0","name":"人气值"},{"value":"6876","name":"经验"}],"constellation":"","is_my_friend":"0"}
     * extcredits : {"1":{"img":"","title":"金币","unit":"枚","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null},"2":{"img":"","title":"荣誉","unit":"点","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null},"3":{"img":"","title":"超丸","unit":"颗","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null},"4":{"img":"","title":"人气值","unit":"","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null},"5":{"img":"","title":"经验","unit":"","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null}}
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
    private SpaceBean space;
    private ExtcreditsBeanX extcredits;

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

    public SpaceBean getSpace() {
        return space;
    }

    public void setSpace(SpaceBean space) {
        this.space = space;
    }

    public ExtcreditsBeanX getExtcredits() {
        return extcredits;
    }

    public void setExtcredits(ExtcreditsBeanX extcredits) {
        this.extcredits = extcredits;
    }

    public static class NoticeBean {
        /**
         * newpush : 0
         * newpm : 0
         * newprompt : 1
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

    public static class SpaceBean {
        /**
         * uid : 8619674
         * username : 呵呵不能死
         * regdate : 2014-3-24 15:11
         * credits : 4584
         * friends : 22
         * posts : 1716
         * threads : 675
         * feedfriend : 8465189,8518613,8836832,8793447,8969982,8567180,8867417,8629300,8536468,8441282,600844,8756238,8479676,8618563,8517556,338078,8728136,624369,8629606,8778784,8538033,8527416
         * gender : 0
         * group : {"grouptitle":"LV7"}
         * avatar : http://u.sgamer.com/uc_server/data/avatar/008/61/96/74_avatar_big.jpg
         * self :
         * extcredits : [{"value":"6939","name":"金币"},{"value":"3966","name":"荣誉"},{"value":"0","name":"超丸"},{"value":"0","name":"人气值"},{"value":"6876","name":"经验"}]
         * constellation :
         * is_my_friend : 0
         */

        private String uid;
        private String username;
        private String regdate;
        private String credits;
        private String friends;
        private String posts;
        private String threads;
        private String feedfriend;
        private String gender;
        private GroupBean group;
        private String avatar;
        private String self;
        private String constellation;
        private String is_my_friend;
        private List<ExtcreditsBean> extcredits;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRegdate() {
            return regdate;
        }

        public void setRegdate(String regdate) {
            this.regdate = regdate;
        }

        public String getCredits() {
            return credits;
        }

        public void setCredits(String credits) {
            this.credits = credits;
        }

        public String getFriends() {
            return friends;
        }

        public void setFriends(String friends) {
            this.friends = friends;
        }

        public String getPosts() {
            return posts;
        }

        public void setPosts(String posts) {
            this.posts = posts;
        }

        public String getThreads() {
            return threads;
        }

        public void setThreads(String threads) {
            this.threads = threads;
        }

        public String getFeedfriend() {
            return feedfriend;
        }

        public void setFeedfriend(String feedfriend) {
            this.feedfriend = feedfriend;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public GroupBean getGroup() {
            return group;
        }

        public void setGroup(GroupBean group) {
            this.group = group;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public String getIs_my_friend() {
            return is_my_friend;
        }

        public void setIs_my_friend(String is_my_friend) {
            this.is_my_friend = is_my_friend;
        }

        public List<ExtcreditsBean> getExtcredits() {
            return extcredits;
        }

        public void setExtcredits(List<ExtcreditsBean> extcredits) {
            this.extcredits = extcredits;
        }

        public static class GroupBean {
            /**
             * grouptitle : LV7
             */

            private String grouptitle;

            public String getGrouptitle() {
                return grouptitle;
            }

            public void setGrouptitle(String grouptitle) {
                this.grouptitle = grouptitle;
            }
        }

        public static class ExtcreditsBean {
            /**
             * value : 6939
             * name : 金币
             */

            private String value;
            private String name;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class ExtcreditsBeanX {
        /**
         * 1 : {"img":"","title":"金币","unit":"枚","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null}
         * 2 : {"img":"","title":"荣誉","unit":"点","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null}
         * 3 : {"img":"","title":"超丸","unit":"颗","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null}
         * 4 : {"img":"","title":"人气值","unit":"","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null}
         * 5 : {"img":"","title":"经验","unit":"","ratio":"0","showinthread":null,"allowexchangein":null,"allowexchangeout":null}
         */

        @SerializedName("1")
        private _$1Bean _$1;
        @SerializedName("2")
        private _$2Bean _$2;
        @SerializedName("3")
        private _$3Bean _$3;
        @SerializedName("4")
        private _$4Bean _$4;
        @SerializedName("5")
        private _$5Bean _$5;

        public _$1Bean get_$1() {
            return _$1;
        }

        public void set_$1(_$1Bean _$1) {
            this._$1 = _$1;
        }

        public _$2Bean get_$2() {
            return _$2;
        }

        public void set_$2(_$2Bean _$2) {
            this._$2 = _$2;
        }

        public _$3Bean get_$3() {
            return _$3;
        }

        public void set_$3(_$3Bean _$3) {
            this._$3 = _$3;
        }

        public _$4Bean get_$4() {
            return _$4;
        }

        public void set_$4(_$4Bean _$4) {
            this._$4 = _$4;
        }

        public _$5Bean get_$5() {
            return _$5;
        }

        public void set_$5(_$5Bean _$5) {
            this._$5 = _$5;
        }

        public static class _$1Bean {
            /**
             * img :
             * title : 金币
             * unit : 枚
             * ratio : 0
             * showinthread : null
             * allowexchangein : null
             * allowexchangeout : null
             */

            private String img;
            private String title;
            private String unit;
            private String ratio;
            private Object showinthread;
            private Object allowexchangein;
            private Object allowexchangeout;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getRatio() {
                return ratio;
            }

            public void setRatio(String ratio) {
                this.ratio = ratio;
            }

            public Object getShowinthread() {
                return showinthread;
            }

            public void setShowinthread(Object showinthread) {
                this.showinthread = showinthread;
            }

            public Object getAllowexchangein() {
                return allowexchangein;
            }

            public void setAllowexchangein(Object allowexchangein) {
                this.allowexchangein = allowexchangein;
            }

            public Object getAllowexchangeout() {
                return allowexchangeout;
            }

            public void setAllowexchangeout(Object allowexchangeout) {
                this.allowexchangeout = allowexchangeout;
            }
        }

        public static class _$2Bean {
            /**
             * img :
             * title : 荣誉
             * unit : 点
             * ratio : 0
             * showinthread : null
             * allowexchangein : null
             * allowexchangeout : null
             */

            private String img;
            private String title;
            private String unit;
            private String ratio;
            private Object showinthread;
            private Object allowexchangein;
            private Object allowexchangeout;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getRatio() {
                return ratio;
            }

            public void setRatio(String ratio) {
                this.ratio = ratio;
            }

            public Object getShowinthread() {
                return showinthread;
            }

            public void setShowinthread(Object showinthread) {
                this.showinthread = showinthread;
            }

            public Object getAllowexchangein() {
                return allowexchangein;
            }

            public void setAllowexchangein(Object allowexchangein) {
                this.allowexchangein = allowexchangein;
            }

            public Object getAllowexchangeout() {
                return allowexchangeout;
            }

            public void setAllowexchangeout(Object allowexchangeout) {
                this.allowexchangeout = allowexchangeout;
            }
        }

        public static class _$3Bean {
            /**
             * img :
             * title : 超丸
             * unit : 颗
             * ratio : 0
             * showinthread : null
             * allowexchangein : null
             * allowexchangeout : null
             */

            private String img;
            private String title;
            private String unit;
            private String ratio;
            private Object showinthread;
            private Object allowexchangein;
            private Object allowexchangeout;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getRatio() {
                return ratio;
            }

            public void setRatio(String ratio) {
                this.ratio = ratio;
            }

            public Object getShowinthread() {
                return showinthread;
            }

            public void setShowinthread(Object showinthread) {
                this.showinthread = showinthread;
            }

            public Object getAllowexchangein() {
                return allowexchangein;
            }

            public void setAllowexchangein(Object allowexchangein) {
                this.allowexchangein = allowexchangein;
            }

            public Object getAllowexchangeout() {
                return allowexchangeout;
            }

            public void setAllowexchangeout(Object allowexchangeout) {
                this.allowexchangeout = allowexchangeout;
            }
        }

        public static class _$4Bean {
            /**
             * img :
             * title : 人气值
             * unit :
             * ratio : 0
             * showinthread : null
             * allowexchangein : null
             * allowexchangeout : null
             */

            private String img;
            private String title;
            private String unit;
            private String ratio;
            private Object showinthread;
            private Object allowexchangein;
            private Object allowexchangeout;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getRatio() {
                return ratio;
            }

            public void setRatio(String ratio) {
                this.ratio = ratio;
            }

            public Object getShowinthread() {
                return showinthread;
            }

            public void setShowinthread(Object showinthread) {
                this.showinthread = showinthread;
            }

            public Object getAllowexchangein() {
                return allowexchangein;
            }

            public void setAllowexchangein(Object allowexchangein) {
                this.allowexchangein = allowexchangein;
            }

            public Object getAllowexchangeout() {
                return allowexchangeout;
            }

            public void setAllowexchangeout(Object allowexchangeout) {
                this.allowexchangeout = allowexchangeout;
            }
        }

        public static class _$5Bean {
            /**
             * img :
             * title : 经验
             * unit :
             * ratio : 0
             * showinthread : null
             * allowexchangein : null
             * allowexchangeout : null
             */

            private String img;
            private String title;
            private String unit;
            private String ratio;
            private Object showinthread;
            private Object allowexchangein;
            private Object allowexchangeout;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getRatio() {
                return ratio;
            }

            public void setRatio(String ratio) {
                this.ratio = ratio;
            }

            public Object getShowinthread() {
                return showinthread;
            }

            public void setShowinthread(Object showinthread) {
                this.showinthread = showinthread;
            }

            public Object getAllowexchangein() {
                return allowexchangein;
            }

            public void setAllowexchangein(Object allowexchangein) {
                this.allowexchangein = allowexchangein;
            }

            public Object getAllowexchangeout() {
                return allowexchangeout;
            }

            public void setAllowexchangeout(Object allowexchangeout) {
                this.allowexchangeout = allowexchangeout;
            }
        }
    }
}
