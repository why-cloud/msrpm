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
@TableName("employeetrain")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Employeetrain对象", description="")
public class Employeetrain implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @TableField(exist = false)
    private String name = null;

    @ApiModelProperty(value = "所属部门")
    //@TableField("departmentId")
    private Integer departmentId;

    @ApiModelProperty(value = "培训日期")
    //@TableField("trainDate")
    private Date trainDate;

    @ApiModelProperty(value = "培训内容")
    //@TableField("trainContent")
    private String trainContent;

    @ApiModelProperty(value = "培训结果")
    //@TableField("trainResult")
    private String trainResult;

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
