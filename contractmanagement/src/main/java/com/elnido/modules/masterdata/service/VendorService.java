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
}
