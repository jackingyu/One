package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Material;

import java.util.List;

/**
 * @author baogang
 */
public interface MaterialService extends IService<Material> {

    /**
     * 根据物料类型查询所有物料
     * @param materialGroupCode
     * @return
     */
    List<Material> findMaterialsByMaterialGroupCode(String materialGroupCode);
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
