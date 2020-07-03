package com.bwsk.entity;

/**
 * 用户对应的部门
 */
public class DeptUser {

    private int uid;//用户ID

    private int deptid;//部门ID

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }
}
