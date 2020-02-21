package com.elnido.modules.masterdata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author baogang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("vendor")
@ApiModel(value = "供应商对象", description = "供应商表")
public class Vendor implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    @JsonIgnore
    private String id;

    @ApiModelProperty(value = "供应商编码")
    private String vendorCode;

    @ApiModelProperty(value = "供应商名称")
    private String vendorName;

    @ApiModelProperty(value = "联络人")
    private String contactPerson;

    @ApiModelProperty(value = "供应商分组ID")
    @Dict(dicCode = "vendor_group")
    private String vendorGroupCode;

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

    @ApiModelProperty(value = "银行账户")
    @TableField(exist = false)
    private List<BankAccount> bankAccounts;

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
}
