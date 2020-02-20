package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.model.ProjectPage;
import com.elnido.modules.masterdata.model.VendorPage;

/**
 * @author baogang
 */
public interface ProjectService extends IService<Project> {

    /**
     * 新建项目
     * @param project
     * @return
     */
    boolean createProject(Project project);

    /**
     * 更新项目
     * @param project
     * @return
     */
    boolean updateProject(Project project);

    /**
     * 根据ID查询项目所有信息
     * @param projectId
     * @return
     */
    Project findAssociatedProject(String projectId);
}
