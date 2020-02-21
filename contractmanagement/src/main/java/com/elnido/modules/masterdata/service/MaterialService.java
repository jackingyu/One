package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.model.MaterialPage;

/**
 * @author baogang
 */
public interface MaterialService extends IService<Material> {

    /**
     * 新增物料
     * @param material
     * @return
     */
    boolean createMaterial(Material material);

    /**
     * 更新物料
     * @param material
     * @return
     */
    boolean updateMaterial(Material material);
}
