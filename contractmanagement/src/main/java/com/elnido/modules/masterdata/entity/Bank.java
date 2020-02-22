package com.elnido.modules.masterdata.entity;

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

import java.util.Date;

/**
 * @author baogang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("banks")
@ApiModel(value = "银行对象", description = "银行表")
public class Bank {

    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    @JsonIgnore
    private String id;

    @ApiModelProperty(value = "bankId")
    private String bankId;

    @ApiModelProperty(value = "bankName")
    private String bankName;

    @ApiModelProperty(value = "subBranchName")
    private String subBranchName;

    @ApiModelProperty(value = "subBranchId")
    private String subBranchId;
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
