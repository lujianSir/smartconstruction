package com.bwsk.entity;

/**
 * 当前用户登录的企业
 */
public class CurrentUserCompany {

    private int uid;

    private int cid;//

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}