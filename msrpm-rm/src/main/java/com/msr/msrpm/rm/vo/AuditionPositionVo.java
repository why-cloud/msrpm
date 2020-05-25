package com.msr.msrpm.rm.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.msr.msrpm.rm.entity.Position;
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
@ApiModel(value="AuditionPosition对象", description="")
public class AuditionPositionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "面试职位")
    @TableField("appli_posId")
    private Integer appliPosid;

    @ApiModelProperty(value = "面试时间")
    private Date auditionTime;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "面试轮次")
    private String auditionNum;

    @ApiModelProperty(value = "面试官")
    private String auditionPer;

    @ApiModelProperty(value = "面试结果")
    private String result;

    @TableField(exist = false)
    private Position position;


}
