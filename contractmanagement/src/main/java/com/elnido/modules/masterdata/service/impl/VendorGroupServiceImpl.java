package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.entity.VendorGroup;
import com.elnido.modules.masterdata.mapper.MaterialMapper;
import com.elnido.modules.masterdata.mapper.VendorGroupMapper;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.service.ServicesUtil;
import com.elnido.modules.masterdata.service.VendorGroupService;
import com.elnido.modules.masterdata.vo.MaterialVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baogang
 */
@Service
public class VendorGroupServiceImpl extends ServiceImpl<VendorGroupMapper, VendorGroup> implements VendorGroupService {


}
