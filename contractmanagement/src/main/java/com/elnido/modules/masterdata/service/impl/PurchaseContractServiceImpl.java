package com.elnido.modules.masterdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.*;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.mapper.PurchaseContractMapper;
import com.elnido.modules.masterdata.mapper.VendorMapper;
import com.elnido.modules.masterdata.service.*;
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
public class PurchaseContractServiceImpl extends ServiceImpl<PurchaseContractMapper, PurchaseContract> implements PurchaseContractService {

    @Resource
    private PurchaseContractItemService purchaseContractItemService;

    @Resource
    private MaterialService materialService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createPurchaseContract(PurchaseContract purchaseContract) {
        ServicesUtil.validateParameterNotNull(purchaseContract, "采购合同数据不能为空");
        ServicesUtil.validateParameterNotNull(purchaseContract.getPurchaseContractItems(), "采购合同行项目不能为空");
        boolean createdPurchaseContract = save(purchaseContract);

        List<PurchaseContractItem> purchaseContractItemList = purchaseContract.getPurchaseContractItems();
        List<PurchaseContractItem> fulfilledPurchaseContractItemList = purchaseContractItemList.stream()
                .map(purchaseContractItem -> {
                    String materialId = purchaseContractItem.getMaterialId();
                    Material material = materialService.getById(materialId);
                    purchaseContractItem.setMaterialCode(material.getMaterialCode());
                    purchaseContractItem.setMaterialName(material.getMaterialName());
                    purchaseContractItem.setMaterialDescription(material.getMaterialDescription());
                    return purchaseContractItem;
                })
                .collect(Collectors.toList());

        boolean createdPurchaseContractItems = purchaseContractItemService.saveBatch(fulfilledPurchaseContractItemList);
        return createdPurchaseContract && createdPurchaseContractItems;
    }
}
