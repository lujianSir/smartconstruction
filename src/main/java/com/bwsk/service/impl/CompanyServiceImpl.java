package com.bwsk.service.impl;

import com.bwsk.entity.*;
import com.bwsk.mapper.CompanyMapper;
import com.bwsk.service.CompanyService;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> queryCompanyByUidOrCid(Company company) {
        // TODO Auto-generated method stub
        return companyMapper.queryCompanyByUidOrCid(company);
    }

    @Override
    public List<Company> queryCompanyUserByUid(CompanyUser companyUser) {
        return companyMapper.queryCompanyUserByUid(companyUser);
    }

    @Override
    public Result<?> insertOrUpdateCompany(Company company) {
        // TODO Auto-generated method stub

        if (company.getCid() > 0) {// 存在 修改
            Company cpany = companyMapper.queryCompanyByCid(company.getCid());
            if (company.getCname().equals(cpany.getCname())) {
                companyMapper.updateCompany(company);
                return Result.success("修改成功");
            } else {
                Company c = companyMapper.queryCompanyByCname(company.getCname());//是否重复
                if (c != null) {
                    return Result.error(500, "名称重复");
                } else {
                    companyMapper.updateCompany(company);
                    return Result.success("修改成功");
                }
            }


        } else {
            Company cpany = companyMapper.queryCompanyByCname(company.getCname());
            if (cpany != null) {
                return Result.error(500, "名称重复");
            } else {
                String currentTime = Utils.getCurrent();
                company.setCreattime(currentTime);
                companyMapper.insertCompany(company);
                CompanyUser companyUser = new CompanyUser();
                companyUser.setCid(company.getCid());
                companyUser.setUid(company.getUid());
                companyMapper.insertCompanyUser(companyUser);

                CurrentUserCompany currentUserCompany = new CurrentUserCompany();
                currentUserCompany.setCid(company.getCid());
                currentUserCompany.setUid(company.getUid());
                companyMapper.insertCurrentUserCompany(currentUserCompany);
                return Result.success("添加成功");
            }
        }

    }

    @Override
    public int deleteCompanyByCid(int cid) {
        // TODO Auto-generated method stub
        return companyMapper.deleteCompanyByCid(cid);
    }

    @Override
    public Result<?> insertApplayCompanyUser(ApplayCompanyUser applayCompanyUser) {
        String creattime = Utils.getCurrentHMS();
        applayCompanyUser.setCreattime(creattime);
        int row = companyMapper.insertApplayCompanyUser(applayCompanyUser);
        if (row > 0) {
            return Result.success("申请成功");
        } else {
            return Result.error(500, "申请失败");
        }
    }

    @Override
    public Result<?> queryCompanyByCnameOrCabbreviation(Company company) {
        return Result.success(companyMapper.queryCompanyByCnameOrCabbreviation(company));
    }

    @Override
    public Result<?> queryApplayCompanyUser(ApplayCompanyUser applayCompanyUser) {
        List<ApplayCompanyUser> list = companyMapper.queryApplayCompanyUser(applayCompanyUser);
        return Result.success(list);
    }

    @Override
    public Result<?> insertCompanyUser(CompanyUser companyUser) {
        companyMapper.insertCompanyUser(companyUser);
        CurrentUserCompany currentUserCompany = new CurrentUserCompany();
        currentUserCompany.setUid(companyUser.getUid());
        currentUserCompany.setCid(companyUser.getCid());
        CurrentUserCompany usercompany = companyMapper.queryCurrentUserCompanyByUid(currentUserCompany);
        if (usercompany == null) {
            companyMapper.insertCurrentUserCompany(currentUserCompany);
        } else {
            companyMapper.updateCurrentUserCompany(currentUserCompany);
        }
        companyMapper.deleteApplayCompanyUser(companyUser);
        return Result.success("操作成功");
    }

    @Override
    public Result<?> deleteApplayCompanyUser(CompanyUser companyUser) {
        companyMapper.deleteApplayCompanyUser(companyUser);
        return Result.success("操作成功");
    }

    @Override
    public Result<?> queryCompanyUser(CompanyUser companyUser) {
        List<CompanyUser> list = companyMapper.queryCompanyUser(companyUser);
        return Result.success(list);
    }

    @Override
    public Result<?> queryDeptFromCompany(Company company) {
        List<Dept> deptList = companyMapper.queryDeptFromCompany(company);
        deptList.removeAll(Collections.singleton(null));
        if (deptList.size() > 0) {
            for (int i = 0; i < deptList.size(); i++) {
                List<User> userList = deptList.get(i).getUserList();
                if (userList.size() > 0) {
                    deptList.get(i).setTotaluser(userList.size() + "人");
                } else {
                    deptList.get(i).setTotaluser("0人");
                }

            }

        }
        return Result.success(deptList);
    }

    @Override
    public Result<?> queryAllUserByDeptId(Dept dept, String username) {
        List<CompanyUser> list = companyMapper.queryAllUserByDeptId(dept, username);
//        if (list.size() > 0) {
//            for (int i = 0; i < list.size(); i++) {
//                CompanyUser companyUser = list.get(i);
//                if (companyUser.getUserstyle() == 1) {
//                    list.get(i).setFlag(true);
//                } else {
//                    list.get(i).setFlag(false);
//                }
//            }
//        }
        return Result.success(list);
    }

}
