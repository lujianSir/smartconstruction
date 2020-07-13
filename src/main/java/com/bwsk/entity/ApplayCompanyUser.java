package com.bwsk.entity;

import java.io.Serializable;

/**
 * 申请的用户
 */
public class ApplayCompanyUser implements Serializable {

    private int cid;//企业ID
    private int uid;//用户ID
    private String username;//用户名称
    private String telphone;//电话
    private String remark;//备注
    private String creattime;//创建时间

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

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
