package com.bwsk.mapper;

import com.bwsk.entity.ApplayProjectUser;
import com.bwsk.entity.Project;
import com.bwsk.entity.ProjectUser;
import org.apache.ibatis.annotations.Param;
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


    //通过项目名称或者编号模糊查询
    List<Project> queryAllProjectByPnameOrPnumber(@Param("str") String str, @Param("uid") int uid);

    //添加发起申请
    int insertApplayProjectUser(ApplayProjectUser applayProjectUser);

    //通过项目的ID查询所有的申请人员
    List<ApplayProjectUser> queryApplayProjectUserByPid(int pid);

    //删除申请
    int deleteApplayProjectUser(ApplayProjectUser applayProjectUser);

}
