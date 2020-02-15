package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.MaterialGroup;
import com.elnido.modules.masterdata.mapper.MaterialGroupMapper;
import com.elnido.modules.masterdata.service.MaterialGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baogang
 */
@Service
public class MaterialGroupServiceImpl extends ServiceImpl<MaterialGroupMapper, MaterialGroup> implements MaterialGroupService {

    @Resource
    private MaterialGroupMapper materialGroupMapper;

    @Override
    public List<MaterialGroup> findAllMaterialGroups() {
        return materialGroupMapper.selectList(null);
    }
}
