package com.bwsk.entity;

public class Material {

    private int mtid;// 材料ID

    private String mtname;// 材料名称

    private String mttime;// 进场时间

    private String mttimerub;// 进场时间搓

    private String mttimechinese;// 收款日期 (年、月、日)

    private int mttype;// 类型 1结构部分 2 维护部分

    private String mttypename;// 类型名称

    private String mtremark;// 备注

    private String remindcomment;// 提醒内容

    private int remindstatus;// 提醒状态

    private int mtstatus;// 0.未进场 1.已进场

    private String mtstatusname;// 名称

    private int pid;// 项目的ID

    private boolean flag;//

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMttimerub() {
        return mttimerub;
    }

    public void setMttimerub(String mttimerub) {
        this.mttimerub = mttimerub;
    }

    public String getMttypename() {
        return mttypename;
    }

    public void setMttypename(String mttypename) {
        this.mttypename = mttypename;
    }

    public String getMtstatusname() {
        return mtstatusname;
    }

    public void setMtstatusname(String mtstatusname) {
        this.mtstatusname = mtstatusname;
    }

    public int getMtid() {
        return mtid;
    }

    public void setMtid(int mtid) {
        this.mtid = mtid;
    }

    public String getMtname() {
        return mtname;
    }

    public void setMtname(String mtname) {
        this.mtname = mtname;
    }

    public String getMttime() {
        return mttime;
    }

    public void setMttime(String mttime) {
        this.mttime = mttime;
    }

    public int getMttype() {
        return mttype;
    }

    public void setMttype(int mttype) {
        this.mttype = mttype;
    }

    public String getMtremark() {
        return mtremark;
    }

    public void setMtremark(String mtremark) {
        this.mtremark = mtremark;
    }

    public int getMtstatus() {
        return mtstatus;
    }

    public void setMtstatus(int mtstatus) {
        this.mtstatus = mtstatus;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getMttimechinese() {
        return mttimechinese;
    }

    public void setMttimechinese(String mttimechinese) {
        this.mttimechinese = mttimechinese;
    }

    public String getRemindcomment() {
        return remindcomment;
    }

    public void setRemindcomment(String remindcomment) {
        this.remindcomment = remindcomment;
    }

    public int getRemindstatus() {
        return remindstatus;
    }

    public void setRemindstatus(int remindstatus) {
        this.remindstatus = remindstatus;
    }

}
