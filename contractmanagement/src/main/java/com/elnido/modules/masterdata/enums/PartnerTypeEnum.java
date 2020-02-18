package com.elnido.modules.masterdata.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * @author baogang
 */
@Getter
public enum PartnerTypeEnum implements IEnum<String> {
    /**
     * 公司
     */
    COMPANY("C", "公司"),
    /**
     * 供应商
     */
    VENDOR("K", "供应商"),
    /**
     * 客户
     */
    CUSTOMER("V", "客户");

    private final String value;
    private final String desc;

    PartnerTypeEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return value;
    }
}
