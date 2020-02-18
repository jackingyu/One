package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.masterdata.entity.VendorGroup;
import org.apache.ibatis.annotations.Select;

/**
 * @author baogang
 */
public interface VendorGroupMapper extends BaseMapper<VendorGroup> {

    /**
     * 按供应商组ID查询供应商名称
     * @param id
     * @return
     */
    @Select("SELECT vendor_group_name FROM vendor_group WHERE id = #{id}")
    String findVendorGroupNameById(String id);
}
