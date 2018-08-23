package com.zhangf.unnamed.module.main.model;

import java.util.List;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class HisThreadResult {

    /**
     * avatar : http://u.sgamer.com/uc_server/data/avatar/008/73/75/21_avatar_big.jpg
     * data : [{"tid":"13823675","fid":"44","author":"liangfz","authorid":"8737521","subject":"韩国灵车先死个ma过分吗傻狗们","dateline":"2018-8-23","lastpost":"15秒前","lastposter":"成都吴彦祖","views":"158","replies":"5","forum_name":"DOTA2"},{"tid":"13823384","fid":"44","author":"liangfz","authorid":"8737521","subject":"这openai真的是200ms延迟吗？","dateline":"2018-8-23","lastpost":"2小时前","lastposter":"liangfz","views":"202","replies":"0","forum_name":"DOTA2"},{"tid":"13822516","fid":"44","author":"liangfz","authorid":"8737521","subject":"大师又开始吸橘子了","dateline":"2018-8-22","lastpost":"昨天15:13","lastposter":"Eg_DogTang","views":"466","replies":"2","forum_name":"DOTA2"},{"tid":"13822491","fid":"44","author":"liangfz","authorid":"8737521","subject":"有一说一，这两把怪zhizhizhi的猴子真的没意思","dateline":"2018-8-22","lastpost":"昨天14:19","lastposter":"ggpipi","views":"495","replies":"7","forum_name":"DOTA2"},{"tid":"13821070","fid":"44","author":"liangfz","authorid":"8737521","subject":"太叼了，咚咚咚","dateline":"2018-8-21","lastpost":"前天05:11","lastposter":"liangfz","views":"202","replies":"0","forum_name":"DOTA2"},{"tid":"13821037","fid":"44","author":"liangfz","authorid":"8737521","subject":"steamTV，超清超顺滑","dateline":"2018-8-21","lastpost":"前天04:14","lastposter":"liangfz","views":"314","replies":"3","forum_name":"DOTA2"},{"tid":"13820881","fid":"44","author":"liangfz","authorid":"8737521","subject":"leile今晚的梦幻积分攻略8.21","dateline":"2018-8-20","lastpost":"3天前","lastposter":"liangfz","views":"101","replies":"0","forum_name":"DOTA2"},{"tid":"13820408","fid":"44","author":"liangfz","authorid":"8737521","subject":"VK微博总结","dateline":"2018-8-20","lastpost":"3天前","lastposter":"Meowpass","views":"2383","replies":"35","forum_name":"DOTA2"},{"tid":"13820361","fid":"44","author":"liangfz","authorid":"8737521","subject":"妮谭天天砍","dateline":"2018-8-20","lastpost":"3天前","lastposter":"hercMoray","views":"119","replies":"3","forum_name":"DOTA2"},{"tid":"13819891","fid":"44","author":"liangfz","authorid":"8737521","subject":"iG的zhili离职了","dateline":"2018-8-19","lastpost":"4天前","lastposter":"地质猪","views":"2205","replies":"17","forum_name":"DOTA2"},{"tid":"13819795","fid":"44","author":"liangfz","authorid":"8737521","subject":"VK怎么还没发微博啊","dateline":"2018-8-19","lastpost":"4天前","lastposter":"怼怼怼怼","views":"1591","replies":"23","forum_name":"DOTA2"},{"tid":"13819610","fid":"44","author":"liangfz","authorid":"8737521","subject":"别讨论比赛了，新的珍藏leile","dateline":"2018-8-19","lastpost":"4天前","lastposter":"hercMoray","views":"726","replies":"13","forum_name":"DOTA2"},{"tid":"13819597","fid":"44","author":"liangfz","authorid":"8737521","subject":"别老想着让BBK走了","dateline":"2018-8-19","lastpost":"4天前","lastposter":"badbyeee","views":"648","replies":"3","forum_name":"DOTA2"},{"tid":"13819484","fid":"44","author":"liangfz","authorid":"8737521","subject":"NB酱","dateline":"2018-8-19","lastpost":"4天前","lastposter":"zhangdisr","views":"520","replies":"2","forum_name":"DOTA2"},{"tid":"13819313","fid":"44","author":"liangfz","authorid":"8737521","subject":"这ggng平时不是这样的鸭","dateline":"2018-8-19","lastpost":"4天前","lastposter":"north147","views":"488","replies":"4","forum_name":"DOTA2"},{"tid":"13819280","fid":"44","author":"liangfz","authorid":"8737521","subject":"这notail和jerax","dateline":"2018-8-19","lastpost":"4天前","lastposter":"123混沌123","views":"760","replies":"7","forum_name":"DOTA2"},{"tid":"13819270","fid":"44","author":"liangfz","authorid":"8737521","subject":"意思是光头不让","dateline":"2018-8-19","lastpost":"4天前","lastposter":"听见雨在说","views":"1362","replies":"5","forum_name":"DOTA2"},{"tid":"13819267","fid":"44","author":"liangfz","authorid":"8737521","subject":"leileleile，OG的决心","dateline":"2018-8-19","lastpost":"4天前","lastposter":"Jaskobe","views":"654","replies":"3","forum_name":"DOTA2"},{"tid":"13819249","fid":"44","author":"liangfz","authorid":"8737521","subject":"妮们说OG第二把会直接送iG回家吗？","dateline":"2018-8-19","lastpost":"4天前","lastposter":"123混沌123","views":"298","replies":"2","forum_name":"DOTA2"},{"tid":"13819242","fid":"44","author":"liangfz","authorid":"8737521","subject":"fygod","dateline":"2018-8-19","lastpost":"4天前","lastposter":"神秘的瓜","views":"427","replies":"2","forum_name":"DOTA2"}]
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
         * tid : 13823675
         * fid : 44
         * author : liangfz
         * authorid : 8737521
         * subject : 韩国灵车先死个ma过分吗傻狗们
         * dateline : 2018-8-23
         * lastpost : 15秒前
         * lastposter : 成都吴彦祖
         * views : 158
         * replies : 5
         * forum_name : DOTA2
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
    }
}
