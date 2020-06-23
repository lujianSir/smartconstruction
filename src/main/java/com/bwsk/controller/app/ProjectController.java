package com.bwsk.controller.app;

import com.bwsk.entity.ApplayProjectUser;
import com.bwsk.entity.Project;
import com.bwsk.entity.Result;
import com.bwsk.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目相关的接口
 *
 * @author lujian
 */
@RestController
@RequestMapping("/app/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 添加或者修改项目信息
     *
     * @param project
     * @return
     */
    @RequestMapping(value = "/insertOrUpdateProject", method = RequestMethod.POST)
    public Result<?> insertOrUpdateProject(Project project) {
//		project.setPname("赤壁项目");
//		project.setPabbreviation("赤壁");
//		project.setPnumber("21321");
//		project.setPaddress("湖北崇赤壁");
//		project.setPstatus(2);
//		project.setCid(5);
//		project.setPtype(3);
//		BigDecimal contractamount = new BigDecimal("920");
//		project.setContractamount(contractamount);
//		BigDecimal acceptedamount = new BigDecimal("740");
//		project.setAcceptedamount(acceptedamount);
//		BigDecimal acceptedinvoice = new BigDecimal("430");
//		project.setAcceptedinvoice(acceptedinvoice);
//		project.setTotalartificial(10);
//		project.setApproachDay("2010-3-3");
//		project.setCompleteDay("2019-18-3");
//		project.setPaycondition("非dsda要全部成功");
//		project.setFineremarks("晚3211扣1000");
//		project.setUid(3);
        int row = projectService.insertOrUpdateProject(project);
        if (row > 0) {
            return Result.success("操作成功");
        } else {
            return Result.error(500, "服务端错误");
        }
    }

    /**
     * 项目多种条件查询
     *
     * @param project
     * @return
     */
    @RequestMapping(value = "/queryProject", method = RequestMethod.POST)
    public Result<?> queryProject(Project project) {
        List<Project> list = projectService.queryProject(project);
        return Result.success(list);
    }

    /**
     * 删除项目
     *
     * @param project
     * @return
     */
    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public Result<?> deleteProject(Project project) {
        int row = projectService.deleteProject(project);
        return Result.success(row);
    }

    /**
     * 通过名称或者编号模糊查询
     *
     * @param str
     * @return
     */
    @RequestMapping(value = "queryAllProjectByPnameOrPnumber", method = RequestMethod.POST)
    public Result<?> queryAllProjectByPnameOrPnumber(String str, int uid) {
        List<Project> list = projectService.queryAllProjectByPnameOrPnumber(str, uid);
        return Result.success(list);
    }

    /**
     * 发起申请
     *
     * @param applayProjectUser
     * @return
     */
    @RequestMapping(value = "insertApplayProjectUser", method = RequestMethod.POST)
    public Result<?> insertApplayProjectUser(ApplayProjectUser applayProjectUser) {
        try {
            projectService.insertApplayProjectUser(applayProjectUser);
            return Result.success("操作成功");
        } catch (Exception e) {
            return Result.error(500, "服务器错误");
        }

    }

    /**
     * 通过项目ID查询所有的申请人员
     *
     * @param pid
     * @return
     */
    @RequestMapping(value = "queryApplayProjectUserByPid", method = RequestMethod.POST)
    public Result<?> queryApplayProjectUserByPid(int pid) {
        List<ApplayProjectUser> list = projectService.queryApplayProjectUserByPid(pid);
        return Result.success(list);
    }
}
