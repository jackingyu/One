package com.elnido.modules.masterdata.model;

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
public class CompanyPage<T> extends Page<T> {

    private String companyName;

    public CompanyPage(long current, long size) {
        super(current, size);
    }
}
