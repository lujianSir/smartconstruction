package com.bwsk.entity;

import java.io.Serializable;

/**
 * 发起申请
 */
public class ApplayProjectUser implements Serializable {

    private int pid;//项目ID
    private int uid;//用户ID
    private String rmark;//评论
    private String creattime;//创建时间

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRmark() {
        return rmark;
    }

    public void setRmark(String rmark) {
        this.rmark = rmark;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }
}
