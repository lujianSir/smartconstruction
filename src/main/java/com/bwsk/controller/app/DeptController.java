package com.bwsk.controller.app;

import com.bwsk.entity.Dept;
import com.bwsk.entity.Result;
import com.bwsk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门
 */
@RestController
@RequestMapping("/app/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 添加部门信息
     *
     * @param dept
     * @return
     */
    @RequestMapping(value = "/insertDept", method = RequestMethod.POST)
    public Result<?> insertDept(Dept dept) {
        return deptService.insertDept(dept);
    }

    /**
     * 修改部门信息
     *
     * @param dept
     * @return
     */
    @RequestMapping(value = "/updateDeptByDeptId", method = RequestMethod.POST)
    public Result<?> updateDeptByDeptId(Dept dept) {
        return deptService.updateDeptByDeptId(dept);
    }

    /**
     * 删除部门信息
     *
     * @param dept
     * @return
     */
    @RequestMapping(value = "/deleteDeptByDeptId", method = RequestMethod.POST)
    public Result<?> deleteDeptByDeptId(Dept dept) {
        return deptService.deleteDeptByDeptId(dept);
    }

    /**
     * 通过ID查询部门信息
     *
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryDeptByDeptId", method = RequestMethod.POST)
    public Result<?> queryDeptByDeptId(Dept dept) {
        return deptService.queryDeptByDeptId(dept);
    }

    /**
     * 部门与用户绑定
     *
     * @param users
     * @param deptid
     * @return
     */
    @RequestMapping(value = "/insertDeptByUsers", method = RequestMethod.POST)
    public Result<?> insertDeptByUsers(String users, int deptid) {
        return deptService.insertDeptByUsers(users, deptid);
    }

    /**
     * 用户与部门解绑
     *
     * @param uid
     * @param deptid
     * @return
     */
    @RequestMapping(value = "/deleteDeptByUserId", method = RequestMethod.POST)
    public Result<?> deleteDeptByUserId(int uid, int deptid) {
        return deptService.deleteDeptByUserId(uid, deptid);
    }

    /**
     * 通过部门ID查询里面的人员
     *
     * @param deptid
     * @return
     */
    @RequestMapping(value = "/queryUserByDeptId", method = RequestMethod.POST)
    public Result<?> queryUserByDeptId(int deptid) {
        return deptService.queryUserByDeptId(deptid);
    }

}
