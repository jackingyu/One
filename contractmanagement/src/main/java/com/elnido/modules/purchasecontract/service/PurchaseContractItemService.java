package com.elnido.modules.purchasecontract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.purchasecontract.entity.PurchaseContract;
import com.elnido.modules.purchasecontract.entity.PurchaseContractItem;

/**
 * @author baogang
 */
public interface PurchaseContractItemService extends IService<PurchaseContractItem> {

    /**
     * 根据采购合同行项目ID查询采购合同行详情
     * @param purchaseContractItemId
     * @return
     */
    PurchaseContractItem findAssociatedPurchaseContractItemById(String purchaseContractItemId);
}
