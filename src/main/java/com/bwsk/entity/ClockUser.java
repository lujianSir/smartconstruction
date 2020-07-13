package com.bwsk.entity;

import java.io.Serializable;

public class ClockUser implements Serializable {

    private int cuid;//打卡id

    private int uid;//用户ID

    private int cid;//企业ID

    private int crid;//规则ID

    private String currentday;//当天时间

    private String firsttime;//第一次打卡时间

    private int firststatus;//是否迟到(1-正常，2-迟到)

    private String firstrrmark;//第一次迟到备注

    private String sencondtime;//第二次打卡时间

    private int sencondstyle;//是否迟到(1-正常，2-早退)

    private String sencondrmark;//第二次早退备注

    private String threetime;//第三次打卡时间

    private int threestatus;//是否迟到(1-正常，2-迟到)

    private String threeremark;//第三次迟到备注

    private String fourtime;//第四次打卡时间

    private int fourstyle;//是否迟到(1-正常，2-早退)

    private String fourremark;//第四次早退备注

    private String workovertime;//加班时长(按分钟计算)

    public String getFirstrrmark() {
        return firstrrmark;
    }

    public void setFirstrrmark(String firstrrmark) {
        this.firstrrmark = firstrrmark;
    }

    public String getSencondrmark() {
        return sencondrmark;
    }

    public void setSencondrmark(String sencondrmark) {
        this.sencondrmark = sencondrmark;
    }

    public String getThreeremark() {
        return threeremark;
    }

    public void setThreeremark(String threeremark) {
        this.threeremark = threeremark;
    }

    public String getFourremark() {
        return fourremark;
    }

    public void setFourremark(String fourremark) {
        this.fourremark = fourremark;
    }

    public String getCurrentday() {
        return currentday;
    }

    public void setCurrentday(String currentday) {
        this.currentday = currentday;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCuid() {
        return cuid;
    }

    public void setCuid(int cuid) {
        this.cuid = cuid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public String getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(String firsttime) {
        this.firsttime = firsttime;
    }

    public int getFirststatus() {
        return firststatus;
    }

    public void setFirststatus(int firststatus) {
        this.firststatus = firststatus;
    }

    public String getSencondtime() {
        return sencondtime;
    }

    public void setSencondtime(String sencondtime) {
        this.sencondtime = sencondtime;
    }

    public int getSencondstyle() {
        return sencondstyle;
    }

    public void setSencondstyle(int sencondstyle) {
        this.sencondstyle = sencondstyle;
    }

    public String getThreetime() {
        return threetime;
    }

    public void setThreetime(String threetime) {
        this.threetime = threetime;
    }

    public int getThreestatus() {
        return threestatus;
    }

    public void setThreestatus(int threestatus) {
        this.threestatus = threestatus;
    }

    public String getFourtime() {
        return fourtime;
    }

    public void setFourtime(String fourtime) {
        this.fourtime = fourtime;
    }

    public String getWorkovertime() {
        return workovertime;
    }

    public void setWorkovertime(String workovertime) {
        this.workovertime = workovertime;
    }

    public int getFourstyle() {
        return fourstyle;
    }

    public void setFourstyle(int fourstyle) {
        this.fourstyle = fourstyle;
    }
}
