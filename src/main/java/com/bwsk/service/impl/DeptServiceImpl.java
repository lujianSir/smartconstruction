package com.bwsk.service.impl;

import com.bwsk.entity.Dept;
import com.bwsk.entity.DeptUser;
import com.bwsk.entity.Result;
import com.bwsk.mapper.DeptMapper;
import com.bwsk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Result<?> insertDept(Dept dept) {
        int row = deptMapper.insertDept(dept);
        if (row > 0) {
            return Result.success("添加成功");
        } else {
            return Result.error(500, "添加失败");
        }
    }

    @Override
    public Result<?> updateDeptByDeptId(Dept dept) {
        int row = deptMapper.updateDeptByDeptId(dept);
        if (row > 0) {
            return Result.success("修改成功");
        } else {
            return Result.error(500, "修改失败");
        }
    }

    @Override
    public Result<?> deleteDeptByDeptId(Dept dept) {
        List<DeptUser> deptUsers = deptMapper.queryUserByDeptId(dept.getDeptid());
        if (deptUsers.size() > 0) {
            return Result.error(500, "有绑定数据!");
        }
        int row = deptMapper.deleteDeptByDeptId(dept);
        if (row > 0) {
            return Result.success("删除成功");
        } else {
            return Result.error(501, "删除失败");
        }
    }

    @Override
    public Result<?> queryDeptByDeptId(Dept dept) {
        dept = deptMapper.queryDeptByDeptId(dept);
        return Result.success(dept);
    }

    @Override
    public Result<?> insertDeptByUsers(String users, int deptid) {
        List<DeptUser> list = new ArrayList<DeptUser>();
        if (users != null && !users.equals("")) {
            String[] us = users.split(",");
            for (int i = 0; i < us.length; i++) {
                DeptUser deptUser = new DeptUser();
                deptUser.setUid(Integer.parseInt(us[i]));
                deptUser.setDeptid(deptid);
                list.add(deptUser);
            }
            int row = deptMapper.insertDeptByUsers(list);
            if (row > 0) {
                return Result.success("添加成功");
            } else {
                return Result.error(501, "添加失败");
            }
        } else {
            return Result.error(500, "数据不对");
        }
    }

    @Override
    public Result<?> deleteDeptByUserId(int uid, int deptid) {
        int row = deptMapper.deleteDeptByUserId(uid, deptid);
        if (row > 0) {
            return Result.success("删除成功");
        } else {
            return Result.error(501, "删除失败");
        }
    }

    @Override
    public Result<?> queryUserByDeptId(int deptid) {
        List<DeptUser> list = deptMapper.queryUserByDeptId(deptid);
        return Result.success(list);
    }

    @Override
    public Result<?> queryUserNotDept(Dept dept, String username) {
        return Result.success(deptMapper.queryUserNotDept(dept, username));
    }

    @Override
    public DeptUser queryDeptByUid(int cid, int uid) {
        return deptMapper.queryDeptByUid(cid, uid);

    }

    @Override
    public Result<?> updateDeptUserByUidAndDeptid(Dept dept, String users, String cid) {
        List<DeptUser> list = new ArrayList<DeptUser>();
        if (users != null && !users.equals("")) {
            String[] us = users.split(",");
            for (int i = 0; i < us.length; i++) {
                DeptUser duser = deptMapper.queryDeptByUid(Integer.parseInt(cid), Integer.parseInt(us[i]));
                if (duser != null) {
                    deptMapper.deleteDeptByUserId(Integer.parseInt(us[i]), duser.getDeptid());

                }
                DeptUser deptUser = new DeptUser();
                deptUser.setUid(Integer.parseInt(us[i]));
                deptUser.setDeptid(dept.getDeptid());
                list.add(deptUser);
            }
        }
        deptMapper.deleteDeptUserByDeptId(dept.getDeptid());
        int row = deptMapper.insertDeptByUsers(list);
        if (row > 0) {
            return Result.success("添加成功");
        } else {
            return Result.error(501, "添加失败");
        }
    }
}
