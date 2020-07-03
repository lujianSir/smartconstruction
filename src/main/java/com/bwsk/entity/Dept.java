package com.bwsk.entity;

/**
 * 部门实体
 */
public class Dept {

    private int deptid;//部门ID

    private int cid;//公司的ID

    private String deptname;//部门名称

    private String deptremark;//部门备注


    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptremark() {
        return deptremark;
    }

    public void setDeptremark(String deptremark) {
        this.deptremark = deptremark;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
