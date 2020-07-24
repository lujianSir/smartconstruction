package com.bwsk.entity;

import java.util.List;

/**
 * 打卡统计
 */
public class ClockStatistics {

    private int uid;//

    private int cid;//

    private int crid;//

    private String starttime;//开始时间

    private String endtime;//结束时间

    private int latetotal;//迟到总数

    private int earlytotal;//早退总数

    private int shortagetotal;//缺卡总数

    private List<ClockUser> clockUserList;//异常打卡的数据

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getLatetotal() {
        return latetotal;
    }

    public void setLatetotal(int latetotal) {
        this.latetotal = latetotal;
    }

    public int getEarlytotal() {
        return earlytotal;
    }

    public void setEarlytotal(int earlytotal) {
        this.earlytotal = earlytotal;
    }

    public int getShortagetotal() {
        return shortagetotal;
    }

    public void setShortagetotal(int shortagetotal) {
        this.shortagetotal = shortagetotal;
    }

    public List<ClockUser> getClockUserList() {
        return clockUserList;
    }

    public void setClockUserList(List<ClockUser> clockUserList) {
        this.clockUserList = clockUserList;
    }
}
