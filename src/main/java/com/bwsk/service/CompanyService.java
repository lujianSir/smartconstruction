package com.bwsk.service;

import com.bwsk.entity.*;

import java.util.List;

public interface CompanyService {

    // 通过用户ID或者公司ID查询所有的公司信息
    List<Company> queryCompanyByUidOrCid(Company company);

    // 添加或者修改公司信息
    Result<?> insertOrUpdateCompany(Company company);

    // 通过企业的ID删除企业
    int deleteCompanyByCid(int cid);

    //发起申请
    Result<?> insertApplayCompanyUser(ApplayCompanyUser applayCompanyUser);

    //通过名称或者简称查询
    Result<?> queryCompanyByCnameOrCabbreviation(Company company);

    //查询申请加入的人
    Result<?> queryApplayCompanyUser(ApplayCompanyUser applayCompanyUser);

    //同意申请，添加公司与用户绑定
    Result<?> insertCompanyUser(CompanyUser companyUser);

    //拒绝申请
    Result<?> deleteApplayCompanyUser(CompanyUser companyUser);

    //查询已经加入的人
    Result<?> queryCompanyUser(CompanyUser companyUser);

    //通过企业ID查询部门以及对应的人数s
    Result<?> queryDeptFromCompany(Company company);

    //查询所有的人包括已经在部门下的
    Result<?> queryAllUserByDeptId(Dept dept, String username);
}
