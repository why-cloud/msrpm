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
@ApiModel(value="Employeehiring对象", description="")
public class EmployeehiringVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String name;

    @ApiModelProperty(value = "职位")
    @TableField("posId")
    private Integer posId;

    @ApiModelProperty(value = "入职时间")
    private Date entryTime;

    @ApiModelProperty(value = "电话")
    private String phone;


    @TableField(exist = false)
    private Position position;


}
