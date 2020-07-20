package com.bwsk.entity;

import java.io.Serializable;
import java.util.List;

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

    private List<Dept> deptList;//该企业下面的部门

    private int applaystatus;//是否申请

    private int creatstatus;//是否已经加入

    private int currentcompany;//判断当前的企业

    public int getCurrentcompany() {
        return currentcompany;
    }

    public void setCurrentcompany(int currentcompany) {
        this.currentcompany = currentcompany;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getApplaystatus() {
        return applaystatus;
    }

    public void setApplaystatus(int applaystatus) {
        this.applaystatus = applaystatus;
    }

    public int getCreatstatus() {
        return creatstatus;
    }

    public void setCreatstatus(int creatstatus) {
        this.creatstatus = creatstatus;
    }

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
