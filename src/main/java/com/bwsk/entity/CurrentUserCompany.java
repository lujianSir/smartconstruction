package com.bwsk.entity;

/**
 * 当前用户登录的企业
 */
public class CurrentUserCompany {

    private int uid;

    private int cid;//

    private int crid;//打卡规则

    private String cname;//

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

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
