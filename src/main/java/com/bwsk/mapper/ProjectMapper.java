package com.bwsk.mapper;

import com.bwsk.entity.Project;
import com.bwsk.entity.ProjectUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {

    // 添加项目
    int insertProject(Project project);

    // 项目与用户绑定
    int insertProjectUser(ProjectUser projectuser);

    // 查询项目是否绑定
    Project queryProjecByPid(int pid);

    // 查询是否绑定
    ProjectUser queryProjectUser(ProjectUser projectuser);

    // 修改项目
    int updateProject(Project project);

    // 查询所有的项目
    List<Project> queryProject(Project project);

    // 删除项目
    int deleteProject(Project project);

    // 删除项目对应的日报
    void deleteDailyByPid(Project project);

    // 删除项目对应的绑定人员
    void deleteprojectuser(Project project);


}
