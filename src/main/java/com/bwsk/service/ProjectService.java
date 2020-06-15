package com.bwsk.service;

import com.bwsk.entity.Project;

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
}
