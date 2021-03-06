package com.bwsk.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 打卡规则
 */
public class ClockRule implements Serializable {

    private int crid;//规则ID

    private int cid;//公司ID

    private int uid;//创建人

    private String crname;//规则名称

    private int crstyle;//考勤方式  1.地点

    private String crstylename;

    private String amids;//地址信息

    private List<AddressMessage> addressMessageList;//地址信息

    private int totalamid;//地址总数

    private int userrulestyle;// 人员设置  1.人员  2.部门

    private String userrulestylename;

    private String users;//所有的人员

    private String deptids;//所有的部门

    private String firsttime;//第一次打卡

    private String sencondtime;//第二次打卡

    private int tsstyle;//是否开启4次打卡  1开启  2关闭

    private String threetime;//第三次打卡

    private String fourtime;//第四次打卡

    private String ruledata;//日期设置

    private int holidaystatus;//法定节假日是否休息  1-休息 2-打卡

    private boolean flag = false;//判断是否在打卡范围

    private int isclock;//是否已经打卡过

    private int facestyle;// 1开启 2关闭

    private boolean facestylename;//

    private ClockUser clockUser;

    public boolean isFacestylename() {
        return facestylename;
    }

    public void setFacestylename(boolean facestylename) {
        this.facestylename = facestylename;
    }

    public int getFacestyle() {
        return facestyle;
    }

    public void setFacestyle(int facestyle) {
        this.facestyle = facestyle;
    }

    public List<AddressMessage> getAddressMessageList() {
        return addressMessageList;
    }

    public void setAddressMessageList(List<AddressMessage> addressMessageList) {
        this.addressMessageList = addressMessageList;
    }

    public int getTotalamid() {
        return totalamid;
    }

    public void setTotalamid(int totalamid) {
        this.totalamid = totalamid;
    }

    public String getCrstylename() {
        return crstylename;
    }

    public void setCrstylename(String crstylename) {
        this.crstylename = crstylename;
    }

    public String getUserrulestylename() {
        return userrulestylename;
    }

    public void setUserrulestylename(String userrulestylename) {
        this.userrulestylename = userrulestylename;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public ClockUser getClockUser() {
        return clockUser;
    }

    public void setClockUser(ClockUser clockUser) {
        this.clockUser = clockUser;
    }

    public int getIsclock() {
        return isclock;
    }

    public void setIsclock(int isclock) {
        this.isclock = isclock;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getHolidaystatus() {
        return holidaystatus;
    }

    public void setHolidaystatus(int holidaystatus) {
        this.holidaystatus = holidaystatus;
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public int getCrstyle() {
        return crstyle;
    }

    public void setCrstyle(int crstyle) {
        this.crstyle = crstyle;
    }

    public String getAmids() {
        return amids;
    }

    public void setAmids(String amids) {
        this.amids = amids;
    }

    public int getUserrulestyle() {
        return userrulestyle;
    }

    public void setUserrulestyle(int userrulestyle) {
        this.userrulestyle = userrulestyle;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getDeptids() {
        return deptids;
    }

    public void setDeptids(String deptids) {
        this.deptids = deptids;
    }

    public String getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(String firsttime) {
        this.firsttime = firsttime;
    }

    public String getSencondtime() {
        return sencondtime;
    }

    public void setSencondtime(String sencondtime) {
        this.sencondtime = sencondtime;
    }

    public int getTsstyle() {
        return tsstyle;
    }

    public void setTsstyle(int tsstyle) {
        this.tsstyle = tsstyle;
    }

    public String getThreetime() {
        return threetime;
    }

    public void setThreetime(String threetime) {
        this.threetime = threetime;
    }

    public String getFourtime() {
        return fourtime;
    }

    public void setFourtime(String fourtime) {
        this.fourtime = fourtime;
    }

    public String getRuledata() {
        return ruledata;
    }

    public void setRuledata(String ruledata) {
        this.ruledata = ruledata;
    }
}
