package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.vo.MaterialVO;

/**
 * @author baogang
 */
public interface MaterialService extends IService<Material> {

    /**
     * 根据物料组和物料名称查询物料
     * @param materialPage
     * @return 分页的物料数组
     */
    MaterialPage<MaterialVO> findPagedMaterials(MaterialPage<MaterialVO> materialPage);
}
