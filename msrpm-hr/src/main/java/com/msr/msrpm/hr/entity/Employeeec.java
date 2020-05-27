package com.msr.msrpm.hr.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@TableName("employeeec")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Employeeec对象", description="")
public class Employeeec implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @TableField(exist = false)
    private String name = null;

    @ApiModelProperty(value = "所属部门")
    //@TableField("departmentId")
    private Integer departmentId;

    @TableField(exist = false)
    private String depName = null;

    @ApiModelProperty(value = "奖罚日期")
    //@TableField("ecDate")
    private Date ecDate;

    @ApiModelProperty(value = "奖罚原因")
    //@TableField("ecReason")
    private String ecReason;

    @ApiModelProperty(value = "奖罚分")
    //@TableField("ecPoint")
    private Integer ecPoint;

    @ApiModelProperty(value = "奖罚类别，0：奖，1：罚")
   // @TableField("ecType")
    private Integer ecType;

    @TableField(exist = false)
    private String type = null;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
