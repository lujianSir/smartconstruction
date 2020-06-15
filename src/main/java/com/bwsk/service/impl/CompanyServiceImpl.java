package com.bwsk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwsk.entity.Company;
import com.bwsk.mapper.CompanyMapper;
import com.bwsk.service.CompanyService;
import com.bwsk.util.Utils;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public List<Company> queryCompanyByUidOrCid(Company company) {
		// TODO Auto-generated method stub
		return companyMapper.queryCompanyByUidOrCid(company);
	}

	@Override
	public int insertOrUpdateCompany(Company company) {
		// TODO Auto-generated method stub
		int row = 0;
		if (company.getCid() > 0) {// 存在 修改
			row = companyMapper.updateCompany(company);
		} else {// 不存在 添加
			String currentTime = Utils.getCurrent();
			company.setCreattime(currentTime);
			row = companyMapper.insertCompany(company);
		}
		return row;
	}

	@Override
	public int deleteCompanyByCid(int cid) {
		// TODO Auto-generated method stub
		return companyMapper.deleteCompanyByCid(cid);
	}

}
