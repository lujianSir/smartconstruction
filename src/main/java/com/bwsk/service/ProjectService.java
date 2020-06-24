package com.bwsk.service;

import com.bwsk.entity.ApplayProjectUser;
import com.bwsk.entity.Project;
import com.bwsk.entity.Result;

import java.util.List;

public interface ProjectService {

    // 添加或者修改项目
    int insertOrUpdateProject(Project project);

    // 查询所有的项目
    List<Project> queryProject(Project project);

    // 删除项目
    int deleteProject(Project project);

    // 查询项目是否绑定
    Project queryProjecByPid(int pid);

    //通过项目名称或者编号模糊查询
    List<Project> queryAllProjectByPnameOrPnumber(String str, int uid);

    //添加发起申请
    int insertApplayProjectUser(ApplayProjectUser applayProjectUser);

    //通过项目的ID查询所有的申请人员
    List<ApplayProjectUser> queryApplayProjectUserByPid(int pid);

    //同意申请
    Result<?> agreeApplayUser(ApplayProjectUser applayProjectUser);

    //取消申请
    Result<?> cancelApplayUser(ApplayProjectUser applayProjectUser);
}
