package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.MaterialGroup;

import java.util.List;

/**
 * @author baogang
 */
public interface MaterialGroupService extends IService<MaterialGroup> {

    /**
     * 查询所有物料组
     * @return MaterialGroup集合
     */
    List<MaterialGroup> findAllMaterialGroups();
}
