package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.model.VendorPage;

/**
 * @author baogang
 */
public interface VendorMapper extends BaseMapper<Vendor> {

    /**
     * 按条件查询供应商
     * @param vendorPage
     * @return
     */
    VendorPage<Vendor> findPagedVendor(VendorPage<Vendor> vendorPage);
}
