package com.elnido.modules.purchasecontract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.purchasecontract.entity.PurchaseContract;
import com.elnido.modules.purchasecontract.model.PurchaseContractPage;

import java.util.List;

/**
 * @author baogang
 */
public interface PurchaseContractService extends IService<PurchaseContract> {

    /**
     * 新建采购合同
     * @param purchaseContract
     * @return
     */
    boolean createPurchaseContract(PurchaseContract purchaseContract);

    /**
     * 按条件分页查询采购合同头部信息
     * @param purchaseContractPage
     * @return
     */
    PurchaseContractPage<PurchaseContract> findPagedPurchaseContractHeaders(PurchaseContractPage<PurchaseContract> purchaseContractPage);

    /**
     * 根据采购合同ID查询合同所有信息
     * @param purchaseContractId
     * @return
     */
    PurchaseContract findAssociatedPurchaseContractInfoById(String purchaseContractId);
}
