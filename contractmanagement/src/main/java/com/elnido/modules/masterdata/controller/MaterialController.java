package com.elnido.modules.masterdata.controller;

import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.entity.MaterialGroup;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialGroupService;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.vo.MaterialSearchVO;
import com.elnido.modules.masterdata.vo.MaterialVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.constant.CommonConstant;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "物料维护")
@RestController
@RequestMapping("/masterdata/materials/")
public class MaterialController {

    @Resource
    private MaterialGroupService materialGroupService;

    @Resource
    private MaterialService materialService;

    @GetMapping("materialgroups")
    @ApiOperation(value = "物料组表-查询所有物料组", notes = "物料组表-查询所有物料组")
    public Result<List<MaterialGroup>> searchAllMaterialGroups() {
        Result<List<MaterialGroup>> result = new Result<>();
        List<MaterialGroup> materialGroupList = materialGroupService.findAllMaterialGroups();

        if(Objects.isNull(materialGroupList)) {
            result.error500("未找到对应实体");
        }else {
            result.setResult(materialGroupList);
            result.setSuccess(true);
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value = "物料表-按条件查询物料", notes = "物料表-按条件查询物料")
    public Result<MaterialPage<MaterialVO>> pagedSearchMaterials(MaterialSearchVO materialSearchVO,
                                                                 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<MaterialPage<MaterialVO>> result = new Result<>();
        MaterialPage<MaterialVO> materialPage = new MaterialPage(pageNo, pageSize);
        materialPage.setMaterialGroupCode(materialSearchVO.getMaterialGroupCode());
        materialPage.setMaterialName(materialSearchVO.getMaterialName());

        MaterialPage<MaterialVO> materialVOMaterialPage = materialService.findPagedMaterials(materialPage);
        result.setResult(materialVOMaterialPage);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("")
    @ApiOperation(value = "物料表-新建物料", notes = "物料表-新建物料")
    public Result<Material> createMaterial(@RequestBody Material material) {
        Result<Material> result = new Result<>();
        boolean saved = materialService.createMaterial(material);
        if (saved) {
            result.setResult(material);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "物料表-更新物料", notes = "物料表-更新物料")
    public Result<Material> updateMaterial(@RequestBody Material material) {
        Result<Material> result = new Result<>();
        boolean updated = materialService.updateMaterial(material);
        if (updated) {
            result.setResult(material);
            result.setSuccess(true);
        } else {
            result.setMessage("更新失败!");
            result.setSuccess(false);
        }
        return result;
    }
}
