package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.mapper.MaterialMapper;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.service.ServicesUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baogang
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Override
    public List<Material> findMaterialsByMaterialGroupCode(String materialGroupCode) {
        LambdaQueryWrapper<Material> lambdaQueryWrapper =
                Wrappers.<Material>lambdaQuery().eq(Material::getMaterialGroupCode, materialGroupCode);
        return list(lambdaQueryWrapper);
    }

    @Override
    public boolean createMaterial(Material material) {
        checkMaterial(material);
        return this.save(material);
    }

    @Override
    public boolean updateMaterial(Material material) {
        checkMaterial(material);
        ServicesUtil.validateStringParameterNotBlack(material.getId(), "更新时物料ID不能为空");
        return this.updateById(material);
    }

    private void checkMaterial(Material material) {
        ServicesUtil.validateParameterNotNull(material, "物料不能为空");
        ServicesUtil.validateParameterNotNull(material.getMaterialCode(), "物料代码不能为空");
        ServicesUtil.validateParameterNotNull(material.getMaterialName(), "物料名称不能为空");
        ServicesUtil.validateParameterNotNull(material.getMaterialGroupCode(), "物料组代码不能为空");
    }
}
