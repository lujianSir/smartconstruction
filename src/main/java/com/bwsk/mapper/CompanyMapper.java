package com.bwsk.mapper;

import com.bwsk.entity.ApplayCompanyUser;
import com.bwsk.entity.Company;
import com.bwsk.entity.CompanyUser;
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

    //发起申请
    int insertApplayCompanyUser(ApplayCompanyUser applayCompanyUser);

    List<Company> queryCompanyByCnameOrCabbreviation(Company company);

    //用户创建企业的时候进行绑定
    void insertCompanyUser(CompanyUser companyUser);

    //删除申请人
    void deleteApplayCompanyUser(CompanyUser companyUser);

    //查询所有的申请人员
    List<ApplayCompanyUser> queryApplayCompanyUser(ApplayCompanyUser applayCompanyUser);

    //查询已经加入的人员
    List<CompanyUser> queryCompanyUser(CompanyUser companyUser);

}
