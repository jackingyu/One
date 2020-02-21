package com.elnido.modules.masterdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @GetMapping()
    @ApiOperation(value = "项目表-按条件查询项目信息", notes = "项目表-按条件查询项目商")
    public Result<IPage<Project>> pagedSearchProjects(@RequestParam(name = "projectName", required = false) String projectName,
                                                      @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<IPage<Project>> result = new Result<>();
        IPage<Project> projectIPage = new Page<>(pageNo, pageSize);

        LambdaQueryWrapper<Project> lambdaQueryWrapper =
                Wrappers.<Project>lambdaQuery().like(StringUtils.isNotBlank(projectName), Project::getProjectName, projectName);
        IPage<Project> queriedProjectIPage = projectService.page(projectIPage, lambdaQueryWrapper);
        result.setResult(queriedProjectIPage);
        result.setSuccess(true);
        return result;
    }

    @PostMapping()
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

    @PutMapping()
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
