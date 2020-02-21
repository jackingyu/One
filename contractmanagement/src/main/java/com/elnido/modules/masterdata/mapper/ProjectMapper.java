package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.masterdata.entity.Project;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.model.ProjectPage;
import com.elnido.modules.masterdata.model.VendorPage;

/**
 * @author baogang
 */
public interface ProjectMapper extends BaseMapper<Project> {

    /**
     * 根据ID查询项目所有信息
     * @param projectId
     * @return
     */
    Project findAssociatedProject(String projectId);
}
