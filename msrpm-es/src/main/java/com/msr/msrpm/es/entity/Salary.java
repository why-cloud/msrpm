package com.msr.msrpm.es.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author msr
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Salary对象", description="")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "所属部门")
    private Integer departmentId;

    @ApiModelProperty(value = "基本工资")
    private Integer basicSalary;

    @ApiModelProperty(value = "奖金")
    private Integer bonus;

    @ApiModelProperty(value = "午餐补助")
    private Integer lunchSalary;

    @ApiModelProperty(value = "交通补助")
    private Integer trafficSalary;

    @ApiModelProperty(value = "应发工资")
    private Integer allSalary;

    @ApiModelProperty(value = "养老金基数")
    private Integer pensionBase;

    @ApiModelProperty(value = "养老金比率")
    private Float pensionPer;
    @ApiModelProperty(value = "启用时间")
    //@TableField(fill = FieldFill.INSERT)
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date createDate;
   // private String createDate;
    @ApiModelProperty(value = "医疗基数")
    private Integer medicalBase;

    @ApiModelProperty(value = "医疗保险比率")
    private Float medicalPer;

    @ApiModelProperty(value = "公积金基数")
    private Integer accumulationFundBase;

    @ApiModelProperty(value = "公积金比率")
    private Float accumulationFundPer;

    private String name;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

   @ApiModelProperty(value = "更新时间",example = "2019-01-01 8:00:00")
   @TableField(fill = FieldFill.INSERT)
   private Date gmtModified;


}
