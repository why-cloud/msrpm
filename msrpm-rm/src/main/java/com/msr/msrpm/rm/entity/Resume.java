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
@TableName(value = "resume AS r LEFT JOIN position AS p ON r.appli_posId = p.id")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Resume对象", description="")
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "r.id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("r.rname")
    private String rname;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "最高学历")
    @TableField("tiptopDegree")
    private String tiptopDegree;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "应聘职位")
    @TableField("appli_posId")
    private Integer appliPosid;

    @TableField(value = "p.name")
    private String positionName;

//    @TableField(value = "t.degree")
//    private String degree;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间", example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT,value = "r.gmt_create ")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间", example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT_UPDATE,value = "r.gmt_modified")
    private Date gmtModified;

//    @TableField(exist = false) //不会与表中字段做映射
//    private Position position;
//
//    @TableField(exist = false) //不会与表中字段做映射
//    private Tiptopdegree tiptopdegree;


}
