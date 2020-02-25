package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.masterdata.entity.Company;
import com.elnido.modules.masterdata.entity.Vendor;

/**
 * @author baogang
 */
public interface VendorMapper extends BaseMapper<Vendor> {

    /**
     * 根据公司ID查询供应商全部信息
     * @param id
     * @return
     */
    Vendor findVendorWithBankAccounts(String id);
}
