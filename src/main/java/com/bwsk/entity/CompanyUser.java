package com.bwsk.entity;

import java.io.Serializable;

/**
 * 企业与用户对应
 */
public class CompanyUser implements Serializable {

    private int cid;//企业ID

    private int uid;//用户ID

    private String username;//用户名称

    private String url;//图片

    private int userstyle;//

    private boolean flag;//


    public int getUserstyle() {
        return userstyle;
    }

    public void setUserstyle(int userstyle) {
        this.userstyle = userstyle;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
