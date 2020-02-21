package com.elnido.modules.masterdata.controller;

import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.vo.MaterialSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "物料维护")
@RestController
@RequestMapping("/masterdata/materials")
public class MaterialController {

    @Resource
    private MaterialService materialService;

    @Autowired
    private MessageUtils messageUtils;

    @GetMapping()
    @ApiOperation(value = "物料表-按条件查询物料", notes = "物料表-按条件查询物料")
    public Result<MaterialPage<Material>> pagedSearchMaterials(MaterialSearchVO materialSearchVO,
                                                                 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<MaterialPage<Material>> result = new Result<>();
        MaterialPage<Material> materialPage = new MaterialPage(pageNo, pageSize);
        materialPage.setMaterialGroupCode(materialSearchVO.getMaterialGroupCode());
        materialPage.setMaterialName(materialSearchVO.getMaterialName());

        MaterialPage<Material> searchedMaterialPage = materialService.findPagedMaterials(materialPage);
        result.setResult(searchedMaterialPage);
        result.setSuccess(true);
        return result;
    }

    @PostMapping()
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

    @PutMapping()
    @ApiOperation(value = "物料表-更新物料", notes = "物料表-更新物料")
    public Result<Material> updateMaterial(@RequestBody Material material) {
        Result<Material> result = new Result<>();
        boolean updated = materialService.updateMaterial(material);
        if (updated) {
            result.setResult(material);
            result.setSuccess(true);
        } else {
            result.setMessage(messageUtils.get("base.updatefailed"));
            result.setSuccess(false);
        }
        return result;
    }
}
