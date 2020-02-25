package com.elnido.modules.masterdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.MessageUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @Resource
    private MessageUtils messageUtils;

    @GetMapping
    @ApiOperation(value = "物料表-按条件查询物料", notes = "物料表-按条件查询物料")
    public Result<IPage<Material>> searchPagedMaterials(Material material,
                                                        @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                        HttpServletRequest httpServletRequest) {
        Result<IPage<Material>> result = new Result<>();
        QueryWrapper<Material> queryWrapper = QueryGenerator.initQueryWrapper(material, httpServletRequest.getParameterMap());
        IPage<Material> materialPage = new Page<>(pageNo, pageSize);

        IPage<Material> searchedMaterialPage = materialService.page(materialPage, queryWrapper);
        result.setResult(searchedMaterialPage);
        result.setSuccess(true);
        return result;
    }

    @PostMapping
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

    @PutMapping
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
