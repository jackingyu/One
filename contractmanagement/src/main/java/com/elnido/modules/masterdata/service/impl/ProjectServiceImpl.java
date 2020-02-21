package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.mapper.ProjectMapper;
import com.elnido.modules.masterdata.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author baogang
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public boolean createProject(Project project) {
        ServicesUtil.validateParameterNotNull(project, "项目不能为空");
        return this.save(project);
    }

    @Override
    public boolean updateProject(Project project) {
        ServicesUtil.validateParameterNotNull(project, "项目不能为空");
        ServicesUtil.validateParameterNotNull(project.getCompanyId(), "项目ID不能为空");
        return this.updateById(project);
    }

    @Override
    public Project findAssociatedProject(String projectId) {
        return projectMapper.findAssociatedProject(projectId);
    }
}
