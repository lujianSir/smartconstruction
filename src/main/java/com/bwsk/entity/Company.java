package com.bwsk.entity;

import java.io.Serializable;

/**
 * 公司实体
 *
 * @author lujian
 */
public class Company implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int cid;// ID

    private String cname;// 公司名称

    private String cabbreviation;// 公司简称

    private String weixin;// 绑定微信

    private int uid;// 用户ID

    private String username;// 用户名称

    private String creattime;// 创建的时间

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getCabbreviation() {
        return cabbreviation;
    }

    public void setCabbreviation(String cabbreviation) {
        this.cabbreviation = cabbreviation;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

}
