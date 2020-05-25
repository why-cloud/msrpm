package com.msr.msrpm.rm.query;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "resume查询对象", description = "查询对象封装")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//@TableName(value = "resume AS r LEFT JOIN position AS p ON r.appli_posId = p.id")
public class ResumeQuery implements Serializable {
    private static final long serialVersionUID = 1L;

//    @TableId(value = "r.id", type = IdType.ID_WORKER_STR)
//    private String id;

    @TableField("r.rname")
    private String rname;

//    @ApiModelProperty(value = "性别")
//    private String gender;

//    @ApiModelProperty(value = "最高学历(未关联)")
//    @TableField("tiptopDegreeId")
//    private Integer tiptopDegreeId;

//    @ApiModelProperty(value = "年龄")
//    private String age;
//
//    @ApiModelProperty(value = "电话")
//    private String phone;

    @ApiModelProperty(value = "应聘职位")
    @TableField("appli_posId")
    private Integer appliPosid;

    @TableField(value = "p.name")
    private String positionName;



    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;


}
