package com.msr.msrpm.rm.vo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.msr.msrpm.rm.entity.Position;
import com.msr.msrpm.rm.entity.Tiptopdegree;
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
@ApiModel(value="Resume对象", description="")
public class ResumePositionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "应聘职位")
    @TableField("appli_posId")
    private Integer appliPosid;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "最高学历(未关联)")
    @TableField("tiptopDegreeId")
    private Integer tiptopDegreeId;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "电话")
    private String phone;

//    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
//    @TableLogic
//    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间", example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(exist = false) //不会与表中字段做映射
    private Position position;

    @TableField(exist = false) //不会与表中字段做映射
    private Tiptopdegree tiptopdegree;




}
