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
public class MaterialPage<T> extends Page<T> {

    private Integer materialGroupCode;

    private String materialName;

    public MaterialPage(long current, long size) {
        super(current, size);
    }
}
