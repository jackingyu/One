package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.entity.MaterialGroup;
import com.elnido.modules.masterdata.mapper.MaterialGroupMapper;
import com.elnido.modules.masterdata.mapper.MaterialMapper;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialGroupService;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.vo.MaterialVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baogang
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Resource
    private MaterialMapper materialMapper;


    @Override
    public MaterialPage<MaterialVO> findPagedMaterials(MaterialPage<MaterialVO> materialPage) {
        return materialMapper.findPagedMaterials(materialPage);
    }
}
