package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.entity.Partner2BankAccount;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.mapper.ProjectMapper;
import com.elnido.modules.masterdata.mapper.VendorMapper;
import com.elnido.modules.masterdata.model.ProjectPage;
import com.elnido.modules.masterdata.model.VendorPage;
import com.elnido.modules.masterdata.service.*;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
