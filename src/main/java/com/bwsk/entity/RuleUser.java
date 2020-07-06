package com.bwsk.entity;

import java.io.Serializable;

/**
 * 用户与打卡规则绑定
 */
public class RuleUser implements Serializable {

    private int crid;//规则的ID

    private int uid;//用户的ID

    private int cid;//企业的ID

    private String username;//用户的名称

    private String crname;//打卡名称

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
