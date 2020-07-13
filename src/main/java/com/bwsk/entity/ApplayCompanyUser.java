package com.bwsk.entity;

import java.io.Serializable;

/**
 * 申请的用户
 */
public class ApplayCompanyUser implements Serializable {

    private int cid;//企业ID
    private int uid;//用户ID
    private String remark;//备注
    private String creattime;//创建时间

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }
}
