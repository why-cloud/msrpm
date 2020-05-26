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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Employeeremove对象", description="")
public class Employeeremove implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @TableField(exist = false)
    private String name = null;

    @ApiModelProperty(value = "调动后部门")
    //@TableField("afterDepId")
    private Integer afterDepId;

    @TableField(exist = false)
    private String afterDepName = null;

    @ApiModelProperty(value = "调动后职位")
   // @TableField("afterJobId")
    private Integer afterJobId;

    @TableField(exist = false)
    private String afterJobName = null;

    @ApiModelProperty(value = "调动日期")
    //@TableField("removeDate")
    private Date removeDate;

    @ApiModelProperty(value = "调动原因")
    private String reason;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @ApiModelProperty(value = "调动前部门")
    //@TableField("beforeDepId")
    private Integer beforeDepId;

    @TableField(exist = false)
    private String beforeDepName = null;

    @ApiModelProperty(value = "调动前职位")
    //@TableField("beforeJobId")
    private Integer beforeJobId;

    @TableField(exist = false)
    private String beforeJobName = null;
}
