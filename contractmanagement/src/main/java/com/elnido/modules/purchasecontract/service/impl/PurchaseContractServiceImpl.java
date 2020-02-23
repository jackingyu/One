package com.elnido.modules.purchasecontract.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.*;
import com.elnido.modules.purchasecontract.mapper.PurchaseContractMapper;
import com.elnido.modules.masterdata.service.*;
import com.elnido.modules.purchasecontract.entity.PurchaseContract;
import com.elnido.modules.purchasecontract.entity.PurchaseContractItem;
import com.elnido.modules.purchasecontract.model.PurchaseContractPage;
import com.elnido.modules.purchasecontract.service.PurchaseContractItemService;
import com.elnido.modules.purchasecontract.service.PurchaseContractService;
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

    @Resource
    private PurchaseContractMapper purchaseContractMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createPurchaseContract(PurchaseContract purchaseContract) {
        ServicesUtil.validateParameterNotNull(purchaseContract, "采购合同数据不能为空");
        ServicesUtil.validateParameterNotNull(purchaseContract.getPurchaseContractItems(), "采购合同行项目不能为空");
        boolean createdPurchaseContract = save(purchaseContract);

        final String createdPurchaseContractId = purchaseContract.getId();
        Assert.notNull(createdPurchaseContractId);

        List<PurchaseContractItem> purchaseContractItemList = purchaseContract.getPurchaseContractItems();
        List<PurchaseContractItem> fulfilledPurchaseContractItemList = purchaseContractItemList.stream()
                .map(purchaseContractItem -> {
                    purchaseContractItem.setContractId(createdPurchaseContractId);
                    String materialId = purchaseContractItem.getMaterialId();
                    Material material = materialService.getById(materialId);
                    if (Objects.isNull(material)) {
                        throw new IllegalArgumentException("采购合同中的物料ID不存在！" + materialId);
                    }
                    purchaseContractItem.setMaterialCode(material.getMaterialCode());
                    purchaseContractItem.setMaterialName(material.getMaterialName());
                    purchaseContractItem.setMaterialDescription(material.getMaterialDescription());
                    return purchaseContractItem;
                })
                .collect(Collectors.toList());

        boolean createdPurchaseContractItems = purchaseContractItemService.saveBatch(fulfilledPurchaseContractItemList);
        return createdPurchaseContract && createdPurchaseContractItems;
    }

    @Override
    public PurchaseContractPage<PurchaseContract> findPagedPurchaseContractHeaders(PurchaseContractPage<PurchaseContract> purchaseContractPage) {
        return purchaseContractMapper.findPagedPurchaseContractHeaders(purchaseContractPage);
    }

    @Override
    public PurchaseContract findAssociatedPurchaseContractInfoById(String purchaseContractId) {
        return purchaseContractMapper.findAssociatedPurchaseContractInfoById(purchaseContractId);
    }
}
