package com.bwsk.mapper;

import com.bwsk.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {

    // 通过用户ID查询所有的公司信息
    List<Company> queryCompanyByUidOrCid(Company company);

    // 添加企业信息
    int insertCompany(Company company);

    // 修改企业信息
    int updateCompany(Company company);

    // 通过企业的ID删除企业
    int deleteCompanyByCid(int cid);

    //通过名称查询是否存在
    Company queryCompanyByCname(String cname);

    //通过ID查询是否信息
    Company queryCompanyByCid(int cid);
}
