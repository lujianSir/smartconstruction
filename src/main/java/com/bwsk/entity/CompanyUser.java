package com.bwsk.entity;

import java.io.Serializable;

/**
 * 企业与用户对应
 */
public class CompanyUser implements Serializable {

    private int cid;//企业ID

    private int uid;//用户ID

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
