package com.bwsk.service.impl;

import com.bwsk.entity.Company;
import com.bwsk.entity.Result;
import com.bwsk.mapper.CompanyMapper;
import com.bwsk.service.CompanyService;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Result<?> insertOrUpdateCompany(Company company) {
        // TODO Auto-generated method stub

        if (company.getCid() > 0) {// 存在 修改
            companyMapper.updateCompany(company);
            return Result.success("修改成功");
        } else {
            Company cpany = companyMapper.queryCompanyByCname(company.getCname());
            if (cpany != null) {
                return Result.error(500, "名称重复");
            } else {
                String currentTime = Utils.getCurrent();
                company.setCreattime(currentTime);
                companyMapper.insertCompany(company);
                return Result.success("添加成功");
            }
        }

    }

    @Override
    public int deleteCompanyByCid(int cid) {
        // TODO Auto-generated method stub
        return companyMapper.deleteCompanyByCid(cid);
    }

}
