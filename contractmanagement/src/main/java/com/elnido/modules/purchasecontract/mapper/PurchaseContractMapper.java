package com.elnido.modules.purchasecontract.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.purchasecontract.entity.PurchaseContract;
import com.elnido.modules.purchasecontract.model.PurchaseContractPage;

/**
 * @author baogang
 */
public interface PurchaseContractMapper extends BaseMapper<PurchaseContract> {

    /**
     * 按条件分页查询采购合同
     * @param purchaseContractPage
     * @return
     */
    PurchaseContractPage<PurchaseContract> findPagedPurchaseContractHeaders(PurchaseContractPage<PurchaseContract> purchaseContractPage);

    /**
     * 根据采购合同查询采购合同详情
     * @param purchaseContractId
     * @return
     */
    PurchaseContract findAssociatedPurchaseContractInfoById(String purchaseContractId);
}
