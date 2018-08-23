package com.zhangf.unnamed.module.main.model;

import java.util.List;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class HisReplyResult {

    /**
     * avatar : http://u.sgamer.com/uc_server/data/avatar/009/04/58/61_avatar_big.jpg
     * data : [{"tid":"13823078","fid":"44","author":"智障核桃","authorid":"8978257","subject":"不是，鳖鳖是解说吗？？？V射还要不要脸了啊","dateline":"2018-8-22","lastpost":"3小时前","lastposter":"notailll","views":"914","replies":"9","forum_name":"DOTA2","details":[{"author":"winstalk","pid":"55163669","fid":"44","tid":"13823078","authorid":"9045861","dateline":"2018-08-23 08:29:52","message":"永远不要低估鳖孙的数量"}]}]
     * request_id : 0
     */

    private String avatar;
    private String request_id;
    private List<DataBean> data;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tid : 13823078
         * fid : 44
         * author : 智障核桃
         * authorid : 8978257
         * subject : 不是，鳖鳖是解说吗？？？V射还要不要脸了啊
         * dateline : 2018-8-22
         * lastpost : 3小时前
         * lastposter : notailll
         * views : 914
         * replies : 9
         * forum_name : DOTA2
         * details : [{"author":"winstalk","pid":"55163669","fid":"44","tid":"13823078","authorid":"9045861","dateline":"2018-08-23 08:29:52","message":"永远不要低估鳖孙的数量"}]
         */

        private String tid;
        private String fid;
        private String author;
        private String authorid;
        private String subject;
        private String dateline;
        private String lastpost;
        private String lastposter;
        private String views;
        private String replies;
        private String forum_name;
        private List<DetailsBean> details;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorid() {
            return authorid;
        }

        public void setAuthorid(String authorid) {
            this.authorid = authorid;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getLastpost() {
            return lastpost;
        }

        public void setLastpost(String lastpost) {
            this.lastpost = lastpost;
        }

        public String getLastposter() {
            return lastposter;
        }

        public void setLastposter(String lastposter) {
            this.lastposter = lastposter;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReplies() {
            return replies;
        }

        public void setReplies(String replies) {
            this.replies = replies;
        }

        public String getForum_name() {
            return forum_name;
        }

        public void setForum_name(String forum_name) {
            this.forum_name = forum_name;
        }

        public List<DetailsBean> getDetails() {
            return details;
        }

        public void setDetails(List<DetailsBean> details) {
            this.details = details;
        }

        public static class DetailsBean {
            /**
             * author : winstalk
             * pid : 55163669
             * fid : 44
             * tid : 13823078
             * authorid : 9045861
             * dateline : 2018-08-23 08:29:52
             * message : 永远不要低估鳖孙的数量
             */

            private String author;
            private String pid;
            private String fid;
            private String tid;
            private String authorid;
            private String dateline;
            private String message;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getAuthorid() {
                return authorid;
            }

            public void setAuthorid(String authorid) {
                this.authorid = authorid;
            }

            public String getDateline() {
                return dateline;
            }

            public void setDateline(String dateline) {
                this.dateline = dateline;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }
    }
}
