package com.zhangf.unnamed.module.menu.model;

/**
 * Created by 75232 on 2018/8/21
 * Email：752323877@qq.com
 */
public class DarkRoomEntity {
    @Override
    public String toString() {
        return "DarkRoomEntity{" +
                "userName='" + userName + '\'' +
                ", action='" + action + '\'' +
                ", endTime='" + endTime + '\'' +
                ", actionTime='" + actionTime + '\'' +
                ", actionReason='" + actionReason + '\'' +
                '}';
    }

    /**
     * 用户名
     */
    private String userName;
    /**
     * 操作行为
     */
    private String action;
    /**
     * 过期时间
     */
    private String endTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionReason() {
        return actionReason;
    }

    public void setActionReason(String actionReason) {
        this.actionReason = actionReason;
    }

    /**
     * 操作时间
     */
    private String actionTime;
    /**
     * 操作行为
     */
    private String actionReason;



}
