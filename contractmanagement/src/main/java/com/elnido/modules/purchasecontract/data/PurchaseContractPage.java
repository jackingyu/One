package com.elnido.modules.purchasecontract.data;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author baogang
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class PurchaseContractPage<T> extends Page<T> {

    private String projectId;

    private Integer contractTypeCode;

    private String vendorName;

    public PurchaseContractPage(long current, long size) {
        super(current, size);
    }
}
