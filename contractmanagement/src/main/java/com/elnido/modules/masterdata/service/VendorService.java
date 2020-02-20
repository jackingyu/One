package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.entity.VendorGroup;
import com.elnido.modules.masterdata.model.VendorPage;

/**
 * @author baogang
 */
public interface VendorService extends IService<Vendor> {

    /**
     * 按条件分页查询供应商
     * @param vendorPage
     * @return
     */
    VendorPage<Vendor> findPagedVendor(VendorPage<Vendor> vendorPage);

    /**
     * 新建供应商
     * @param vendor
     * @return
     */
    boolean createVendor(Vendor vendor);
}
