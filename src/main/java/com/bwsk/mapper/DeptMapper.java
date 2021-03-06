package com.bwsk.mapper;

import com.bwsk.entity.Dept;
import com.bwsk.entity.DeptUser;
import com.bwsk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper {
    //添加部门
    int insertDept(Dept dept);

    //修改部门
    int updateDeptByDeptId(Dept dept);

    //删除部门
    int deleteDeptByDeptId(Dept dept);

    //查询部门
    Dept queryDeptByDeptId(Dept dept);

    //部门绑定用户
    int insertDeptByUsers(List<DeptUser> list);

    //部门与用户解绑
    int deleteDeptByUserId(@Param("uid") int uid, @Param("deptid") int deptid);

    //通过部门ID查询对应的人员
    List<DeptUser> queryUserByDeptId(int deptid);

    //查询用户不在部门的
    List<User> queryUserNotDept(@Param("dept") Dept dept, @Param("username") String username);

    //通过用户ID查询部门ID
    DeptUser queryDeptByUid(@Param("cid") int cid, @Param("uid") int uid);

    //根据部门ID删除对应下面绑定的所有人员
    void deleteDeptUserByDeptId(int deptid);
}
