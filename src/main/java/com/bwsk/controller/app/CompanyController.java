package com.bwsk.controller.app;

import com.bwsk.entity.*;
import com.bwsk.service.CompanyService;
import com.bwsk.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 公司相关的接口
 *
 * @author lujian
 */
@RestController
@RequestMapping("/app/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ProjectService projectService;

    /**
     * 通过公司ID或者用户ID查询公司的信息
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "/queryCompanyByUidOrCid", method = RequestMethod.POST)
    public Result<?> queryCompanyByUidOrCid(Company company) {
        List<Company> list = companyService.queryCompanyByUidOrCid(company);
        return Result.success(list);
    }

    /**
     * @param companyUser
     * @return
     */
    @RequestMapping(value = "/queryCompanyUserByUid", method = RequestMethod.POST)
    public Result<?> queryCompanyUserByUid(CompanyUser companyUser) {
        List<Company> list = companyService.queryCompanyUserByUid(companyUser);
        return Result.success(list);
    }

    /**
     * 添加或者修改公司信息
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "/insertOrUpdateCompany", method = RequestMethod.POST)
    public Result<?> insertOrUpdateCompany(Company company) {
        return companyService.insertOrUpdateCompany(company);
    }

    /**
     * 根据ID删除公司信息
     *
     * @param cid
     * @return
     */
    @RequestMapping(value = "/deleteCompanyByCid", method = RequestMethod.POST)
    public Result<?> deleteCompanyByCid(int cid) {
        Project project = new Project();
        project.setCid(cid);
        List<Project> list = projectService.queryProject(project);
        if (list.size() > 0) {
            return Result.error(500, "有绑定数据");
        } else {
            companyService.deleteCompanyByCid(project.getCid());
            return Result.success("删除成功");
        }
    }

    /**
     * 发起申请
     *
     * @param applayCompanyUser
     * @return
     */
    @RequestMapping(value = "/insertApplayCompanyUser", method = RequestMethod.POST)
    public Result<?> insertApplayCompanyUser(ApplayCompanyUser applayCompanyUser) {
        return companyService.insertApplayCompanyUser(applayCompanyUser);
    }

    /**
     * 通过企业名称模糊查询
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "/queryCompanyByCnameOrCabbreviation", method = RequestMethod.POST)
    public Result<?> queryCompanyByCnameOrCabbreviation(Company company) {
        return companyService.queryCompanyByCnameOrCabbreviation(company);
    }

    /**
     * 查询申请加入企业的人
     *
     * @param applayCompanyUser
     * @return
     */
    @RequestMapping(value = "/queryApplayCompanyUser", method = RequestMethod.POST)
    public Result<?> queryApplayCompanyUser(ApplayCompanyUser applayCompanyUser) {
        return companyService.queryApplayCompanyUser(applayCompanyUser);
    }

    /**
     * 查询已经加入的人
     *
     * @param companyUser
     * @return
     */
    @RequestMapping(value = "/queryCompanyUser", method = RequestMethod.POST)
    public Result<?> queryCompanyUser(CompanyUser companyUser) {
        return companyService.queryCompanyUser(companyUser);
    }


    /**
     * 同意，用户与公司绑定
     *
     * @param companyUser
     * @return
     */
    @RequestMapping(value = "/insertCompanyUser", method = RequestMethod.POST)
    public Result<?> insertCompanyUser(CompanyUser companyUser) {
        return companyService.insertCompanyUser(companyUser);
    }

    /**
     * 拒绝
     *
     * @param companyUser
     * @return
     */
    @RequestMapping(value = "/deleteApplayCompanyUser", method = RequestMethod.POST)
    public Result<?> deleteApplayCompanyUser(CompanyUser companyUser) {
        return companyService.deleteApplayCompanyUser(companyUser);
    }

    /**
     * 通过企业ID查询部门以及对应的人数s
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "/queryDeptFromCompany", method = RequestMethod.POST)
    public Result<?> queryDeptFromCompany(Company company) {
        return companyService.queryDeptFromCompany(company);
    }

    /**
     * 查询所有的人包括已经在部门下的
     *
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryAllUserByDeptId", method = RequestMethod.POST)
    public Result<?> queryAllUserByDeptId(Dept dept, String username) {
        return companyService.queryAllUserByDeptId(dept, username);
    }
}
