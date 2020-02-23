package com.elnido.modules.purchasecontract.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.elnido.modules.api.LocalDateSerializer;
import com.elnido.modules.masterdata.entity.Vendor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author baogang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("purchase_contract")
@ApiModel(value = "采购合同对象", description = "采购合同表")
public class PurchaseContract implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "采购合同编码")
    private String contractCode;

    @ApiModelProperty(value = "采购合同标题")
    private String contractTitle;

    @ApiModelProperty(value = "合同类型")
    @Dict(dicCode = "contract_type")
    private Integer contractTypeCode;

    @ApiModelProperty(value = "公司ID")
    @Dict(dicCode = "id", dictTable = "company", dicText = "company_name")
    private String companyId;

    @ApiModelProperty(value = "供应商ID")
    private String vendorId;

    @ApiModelProperty(value = "项目ID")
    @Dict(dicCode = "id", dictTable = "project", dicText = "project_name")
    private String projectId;

    @ApiModelProperty(value = "合同有效期开始时间")
//    @JsonSerialize(using = LocalDateSerializer.class)
    private Date beginDate;

    @ApiModelProperty(value = "合同有效期结束时间")
//    @JsonSerialize(using = LocalDateSerializer.class)
    private Date endDate;

    @ApiModelProperty(value = "联络人")
    private String contactPerson;

    @ApiModelProperty(value = "联络人身份证号码")
    private String contactPersonId;

    @ApiModelProperty(value = "联络人电话")
    private String contactPhone;

    @ApiModelProperty(value = "社会信用代码")
    private String socialCreditCode;

    @ApiModelProperty(value = "纳税人资格")
    private String taxSubject;

    @ApiModelProperty(value = "营业执照号码")
    private String businessLicense;

    @ApiModelProperty(value = "税务登记号")
    private String taxCode;

    @ApiModelProperty(value = "供应商")
    @TableField(exist = false)
    private Vendor vendor;

    @TableField(exist = false)
    private List<PurchaseContractItem> purchaseContractItems;

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
    private LocalDate createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "修改人")
    @JsonIgnore
    private LocalDate updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
    private Date updateTime;
}
