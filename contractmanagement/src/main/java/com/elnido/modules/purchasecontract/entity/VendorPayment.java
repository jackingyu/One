package com.elnido.modules.purchasecontract.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.elnido.modules.validation.InsertValidation;
import com.elnido.modules.validation.UpdateValidation;
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
import java.util.Date;

/**
 * @author baogang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("vendor_payment")
@ApiModel(value = "供应商付款对象", description = "供应商付款表")
public class VendorPayment implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    @NotBlank(groups = {UpdateValidation.class}, message = "{elnido.validation.general.idshouldnotempty}")
    private String id;

    @ApiModelProperty(value = "供应商主键")
    @NotBlank(groups = {InsertValidation.class, UpdateValidation.class}, message = "{elnido.validation.general.vendor.id.should.not.blank}")
    private String vendorId;

    @NotBlank(groups = {InsertValidation.class, UpdateValidation.class}, message = "{elnido.validation.general.company.id.should.not.blank}")
    @ApiModelProperty(value = "公司主键")
    private String companyId;

    @ApiModelProperty(value = "财务年度")
    private Integer financialYear;

    @ApiModelProperty(value = "付款日期")
    private Date paymentDate;

    @ApiModelProperty(value = "付款金额")
    private Double paymentAmount;

    @ApiModelProperty(value = "付款方式编码")
    @Dict(dicCode = "payment_method")
    private Integer paymentMethodCode;

    @ApiModelProperty(value = "供应商银行账号主键")
    private String bankAccountId;

    @ApiModelProperty(value = "备注")
    private String comments;

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
