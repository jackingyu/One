package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Vendor;

/**
 * @author baogang
 */
public interface VendorService extends IService<Vendor> {

    /**
     * 新建供应商
     * @param vendor
     * @return
     */
    boolean createVendor(Vendor vendor);

    /**
     * 根据供应商ID查询供应商详情
     * @param id
     * @return
     */
    Vendor findVendorById(String id);

    /**
     * 更新供应商信息
     * @param vendor
     * @return
     */
    boolean updateVendorWithBankAccounts(Vendor vendor);
}
