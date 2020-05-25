package com.msr.msrpm.rm.entity;

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
@ApiModel(value="Audition对象", description="")
public class Audition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "面试职位")
    @TableField("appli_posId")
    private Integer appliPosid;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "面试时间")
    private Date auditionTime;

    @ApiModelProperty(value = "面试轮次")
    private String auditionNum;

    @ApiModelProperty(value = "面试官")
    private String auditionPer;

    @ApiModelProperty(value = "面试结果")
    private String result;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间", example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间", example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
