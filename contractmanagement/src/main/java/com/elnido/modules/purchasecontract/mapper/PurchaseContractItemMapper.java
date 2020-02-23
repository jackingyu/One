package com.elnido.modules.purchasecontract.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.purchasecontract.entity.PurchaseContractItem;

import java.util.List;

/**
 * @author baogang
 */
public interface PurchaseContractItemMapper extends BaseMapper<PurchaseContractItem> {

    /**
     * 根据采购合同主键查询采购合同行项目
     * @param purchaseContractId
     * @return
     */
    List<PurchaseContractItem> findPurchaseContractItemsByPurchaseContractId(String purchaseContractId);

    /**
     * 根据采购合同行项目ID查询采购合同行项目详细信息
     * @param purchaseContractItemId
     * @return
     */
    PurchaseContractItem findPurchaseContractItemDetailById(String purchaseContractItemId);
}
