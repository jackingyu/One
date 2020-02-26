package com.elnido.modules.finance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author baogang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_gl_account")
@ApiModel(value = "客户总账", description = "客户总账")
public class CustomerGLAccount {

    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "公司ID")
    private String companyId;

    @ApiModelProperty(value = "客户ID")
    private String customerId;

    @ApiModelProperty(value = "财年")
    private String year;

    @ApiModelProperty(value = "货币")
    private String currency;

    @ApiModelProperty(value = "当年结算总额")
    private BigDecimal settlementAmount;

    @ApiModelProperty(value = "当年收款总额")
    private BigDecimal receivedAmount;

    @ApiModelProperty(value = "当年开票总额")
    private BigDecimal billingAmount;

    @ApiModelProperty(value = "上年度欠款结转")
    private BigDecimal cfUnreceivedAmount;

    @ApiModelProperty(value = "上年度未开票结转")
    private BigDecimal cfUnbillingAmount;

    @ApiModelProperty(value = "account key")
    private String accKey;

    @ApiModelProperty(value = "借贷标记")
    private String dcIndicator;

    /**
     * 创建人
     */
    @JsonIgnore
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新人
     */
    @JsonIgnore
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonIgnore
    private Date updateTime;
}
