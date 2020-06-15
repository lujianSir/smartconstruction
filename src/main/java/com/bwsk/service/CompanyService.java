package com.bwsk.service;

import com.bwsk.entity.Company;

import java.util.List;

public interface CompanyService {

    // 通过用户ID或者公司ID查询所有的公司信息
    public List<Company> queryCompanyByUidOrCid(Company company);

    // 添加或者修改公司信息
    public int insertOrUpdateCompany(Company company);

    // 通过企业的ID删除企业
    public int deleteCompanyByCid(int cid);

}
