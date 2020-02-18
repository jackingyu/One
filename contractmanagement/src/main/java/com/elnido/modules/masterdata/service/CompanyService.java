package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.model.CompanyPage;

/**
 * @author baogang
 */
public interface CompanyService extends IService<Company> {

    /**
     * 根据查询条件查询公司
     * @param companyPage
     * @return 分页的公司数组
     */
    CompanyPage<Company> findPagedCompanies(CompanyPage<Company> companyPage);

    /**
     * 创建公司
     * @param company
     * @return
     */
    boolean createCompany(Company company);

    /**
     * 根据公司ID查询公司全部信息
     * @param companyId
     * @return
     */
    Company findCompanyWithBankAccountById(String companyId);
}
