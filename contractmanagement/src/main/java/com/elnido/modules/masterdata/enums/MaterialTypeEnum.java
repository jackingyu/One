package com.elnido.modules.masterdata.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @author baogang
 */
@Getter
public enum MaterialTypeEnum implements IEnum<Integer> {
    /**
     * 一次性物料
     */
    ONE_TIME(0, "一次性物料"),
    /**
     * 供应商
     */
    MULTIPLE_TIME(1, "非一次性物料");

    private final Integer value;
    private final String desc;

    MaterialTypeEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JsonValue
    public Integer jsonValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
