package com.bwsk.entity;

import java.io.Serializable;

public class FaceUserImage implements Serializable {

    private int fuid;

    private int uid;//用户ID

    private int cid;//

    private String fictitiousurl;//虚拟地址

    private String actualurl;//实际地址

    private String username;//姓名

    private String facestyle;// 1 -有人脸 2-没有人脸

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFacestyle() {
        return facestyle;
    }

    public void setFacestyle(String facestyle) {
        this.facestyle = facestyle;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getFuid() {
        return fuid;
    }

    public void setFuid(int fuid) {
        this.fuid = fuid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFictitiousurl() {
        return fictitiousurl;
    }

    public void setFictitiousurl(String fictitiousurl) {
        this.fictitiousurl = fictitiousurl;
    }

    public String getActualurl() {
        return actualurl;
    }

    public void setActualurl(String actualurl) {
        this.actualurl = actualurl;
    }
}
