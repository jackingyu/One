package com.elnido.modules.purchasecontract.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author baogang
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class VendorInvoicePage<T> extends Page<T> {

    private String vendorId;

    private Date beginDate;

    private Date endDate;

    public VendorInvoicePage(long current, long size) {
        super(current, size);
    }
}
