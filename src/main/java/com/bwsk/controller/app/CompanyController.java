package com.bwsk.controller.app;

import com.bwsk.entity.Company;
import com.bwsk.entity.Project;
import com.bwsk.entity.Result;
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
        int row = 0;
        Project project = new Project();
        project.setCid(cid);
        List<Project> list = projectService.queryProject(project);
        if (list.size() > 0) {
            row = 2;
        } else {
            row = companyService.deleteCompanyByCid(cid);
        }
        return Result.success(row);
    }
}
