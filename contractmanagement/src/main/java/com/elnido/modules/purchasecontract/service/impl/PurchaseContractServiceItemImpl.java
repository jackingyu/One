package com.elnido.modules.purchasecontract.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.service.MaterialService;
import com.elnido.modules.masterdata.service.ServicesUtil;
import com.elnido.modules.purchasecontract.entity.PurchaseContract;
import com.elnido.modules.purchasecontract.entity.PurchaseContractItem;
import com.elnido.modules.purchasecontract.mapper.PurchaseContractItemMapper;
import com.elnido.modules.purchasecontract.mapper.PurchaseContractMapper;
import com.elnido.modules.purchasecontract.service.PurchaseContractItemService;
import com.elnido.modules.purchasecontract.service.PurchaseContractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baogang
 */
@Service
public class PurchaseContractServiceItemImpl extends ServiceImpl<PurchaseContractItemMapper, PurchaseContractItem> implements PurchaseContractItemService {

    @Resource
    private PurchaseContractItemMapper purchaseContractItemMapper;

    @Override
    public PurchaseContractItem findAssociatedPurchaseContractItemById(String purchaseContractItemId) {
        return purchaseContractItemMapper.findPurchaseContractItemDetailById(purchaseContractItemId);
    }
}
