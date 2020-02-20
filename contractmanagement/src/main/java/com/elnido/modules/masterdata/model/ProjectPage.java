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
public class ProjectPage<T> extends Page<T> {

    private String name;

    public ProjectPage(long current, long size) {
        super(current, size);
    }
}
