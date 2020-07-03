package com.bwsk.entity;

/**
 * 用户对应的部门
 */
public class DeptUser {

    private int uid;//用户ID

    private String username;//用户名称

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
