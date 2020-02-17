package com.elnido.modules.masterdata.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * @author baogang
 */
@Getter
public enum PartnerTypeEnum implements IEnum<Integer> {
    /**
     * 公司
     */
    COMPANY(1, "公司"),
    /**
     * 供应商
     */
    VENDOR(2, "供应商"),
    /**
     * 客户
     */
    CUSTOMER(3, "客户");

    private final int value;
    private final String desc;

    PartnerTypeEnum(final int value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
