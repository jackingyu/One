package com.elnido.modules.masterdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.model.VendorPage;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.ProjectService;
import com.elnido.modules.masterdata.service.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.elnido.modules.masterdata.Constants.I18N.General.RECORD_NOT_EXIST_KEY;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "项目维护")
@RestController
@RequestMapping("/masterdata/projects")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @Resource
    private MessageUtils messageUtils;

    @GetMapping("/")
    @ApiOperation(value = "项目表-按条件查询项目信息", notes = "项目表-按条件查询项目商")
    public Result<IPage<Project>> pagedSearchProjects(@RequestParam(name = "name", required = false) String name,
                                                      @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<IPage<Project>> result = new Result<>();
        IPage<Project> projectIPage = new Page<>(pageNo, pageSize);

        LambdaQueryWrapper<Project> lambdaQueryWrapper = Wrappers.<Project>lambdaQuery().like(Project::getName, name);
        IPage<Project> queriedProjectIPage = projectService.page(projectIPage, lambdaQueryWrapper);
        result.setResult(queriedProjectIPage);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/")
    @ApiOperation(value = "项目表-新建项目信息", notes = "项目表-新建项目")
    public Result<Project> createProject(@RequestBody Project project) {
        Result<Project> result = new Result<>();

        boolean created = projectService.createProject(project);
        if(created) {
            result.setResult(project);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    @PutMapping("/}")
    @ApiOperation(value = "项目表-更新项目信息", notes = "项目表-更新项目信息")
    public Result<?> updateProject(@RequestBody Project project) {
        Result<Project> result = new Result<>();
        boolean updated = projectService.updateById(project);
        if (updated) {
            result.setResult(project);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }
}
