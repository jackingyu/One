package com.elnido.modules.purchasecontract.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author baogang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("purchase_contract_item")
@ApiModel(value = "采购合同行项目对象", description = "采购合同行项目表")
public class PurchaseContractItem implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    @NotBlank(message = "{elnido.validation.general.idshouldnotempty}")
    private String id;

    @ApiModelProperty(value = "采购合同主键")
    private String contractId;

    @ApiModelProperty(value = "合同行编号")
    private Integer itemNo;

    @ApiModelProperty(value = "物料数据主键")
    private String materialId;

    @ApiModelProperty(value = "物料代码")
    private String materialCode;

    @ApiModelProperty(value = "物料数据名称")
    private String materialName;

    @ApiModelProperty(value = "物料数据描述")
    private String materialDescription;

    @ApiModelProperty(value = "单位代码")
    @Dict(dicCode = "unit")
    private Integer unitCode;

    @ApiModelProperty(value = "数量")
    private BigDecimal quantity;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "约定税率")
    private BigDecimal taxRate;

    @ApiModelProperty(value = "验收标准")
    private String acceptanceCriteria;

    @ApiModelProperty(value = "合同工期")
    private String contractSchedule;

    @ApiModelProperty(value = "质量标准")
    private String qualityStandard;

    @ApiModelProperty(value = "付款方式编码")
    @Dict(dicCode = "payment_method")
    private Integer paymentMethodCode;

    @ApiModelProperty(value = "付款节点")
    private String paymentTerm;

    @ApiModelProperty(value = "保修期限")
    private String warranty;

    @ApiModelProperty(value = "保修条款")
    private String warrantyAgreement;

    @ApiModelProperty(value = "注释")
    private String comments;

    @ApiModelProperty(value = "单位")
    @TableField(exist = false)
    private String unitName;

    @ApiModelProperty(value = "付款方式")
    @TableField(exist = false)
    private String paymentMethodName;


    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @JsonIgnore
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "修改人")
    @JsonIgnore
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
    private Date updateTime;

    /**
     * 逻辑删除标识
     */
    @ApiModelProperty(value = "逻辑删除标识")
    @Dict(dicCode = "del_flag")
    @TableLogic
    private String delFlag;
}
