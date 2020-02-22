package com.elnido.modules.masterdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.masterdata.entity.PurchaseContract;
import com.elnido.modules.masterdata.entity.Vendor;

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
}
