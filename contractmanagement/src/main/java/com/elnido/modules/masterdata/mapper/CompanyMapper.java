package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.elnido.modules.masterdata.entity.Bank;
import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.model.CompanyPage;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.vo.MaterialVO;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * @author baogang
 */
public interface CompanyMapper extends BaseMapper<Company> {

    /**
     * 根据公司名称查询公司
     * @param companyPage
     * @return 分页的公司数组
     */
    CompanyPage<Company> findPagedCompanies(CompanyPage<Company> companyPage);

    /**
     * 根据公司ID查询公司全部信息
     * @param companyId
     * @return
     */
    Company findCompanyWithBankAccounts(String companyId);
}
