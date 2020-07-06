package com.bwsk.service;

import com.bwsk.entity.Dept;
import com.bwsk.entity.Result;

public interface DeptService {

    //添加部门
    Result<?> insertDept(Dept dept);

    //修改部门信息
    Result<?> updateDeptByDeptId(Dept dept);

    //删除部门信息
    Result<?> deleteDeptByDeptId(Dept dept);

    //查询部门信息
    Result<?> queryDeptByDeptId(Dept dept);

    //批量添加用户与部门绑定
    Result<?> insertDeptByUsers(String users, int deptid);

    //用户与部门解绑
    Result<?> deleteDeptByUserId(int uid, int deptid);

    //通过部门ID查询里面的人员
    Result<?> queryUserByDeptId(int deptid);

    //查询用户不在部门的
    Result<?> queryUserNotDept();
}
