package com.bwsk.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bwsk.entity.Company;

@Repository
public interface CompanyMapper {

	// 通过用户ID查询所有的公司信息
	public List<Company> queryCompanyByUidOrCid(Company company);

	// 添加企业信息
	public int insertCompany(Company company);

	// 修改企业信息
	public int updateCompany(Company company);

	// 通过企业的ID删除企业
	public int deleteCompanyByCid(int cid);
}
