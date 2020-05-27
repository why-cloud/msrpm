package com.msr.msrpm.tm.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.msr.msrpm.tm.entity.Department;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TemperatureVo对象", description="")
public class TemperatureVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    private String name;

    @ApiModelProperty(value = "部门id")
    @TableField("departmentId")
    private Integer departmentId;

    @ApiModelProperty(value = "体温")
    private Float temperature;

    @ApiModelProperty(value = "是否正常 1（true）正常， 0（false）异常")
    @TableField("is_unusual")
    private String isUnusual;

    @ApiModelProperty(value = "其他症状")
    @TableField("other_symptoms")
    private String otherSymptoms;
//
//    @ApiModelProperty(value = "创建时间")
//    @TableField(fill = FieldFill.INSERT)
//    private Date gmtCreate;
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(exist = false) //不会与表中字段做映射
    private Department department;

}
