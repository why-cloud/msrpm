package com.msr.msrpm.es.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.msr.msrpm.es.entity.Department;
import com.msr.msrpm.es.entity.Employee;
import com.msr.msrpm.es.entity.Salary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Empsalary对象", description="")
public class SalarySobVo {
    @ApiModelProperty
    //@TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty
    private Integer eid;
    @ApiModelProperty
    private Integer sid;

//    @ApiModelProperty(value = "员工姓名")
//    private String name;
//
//    @ApiModelProperty(value = "工号")
//    @TableField("workID")
//    private String workID;
//
//    @ApiModelProperty(value = "邮箱")
//    private String email;
//
//    @ApiModelProperty(value = "电话号码")
//    private String phone;

    @TableField(exist = false) //不会与表中字段做映射
    private Employee employee;

    @TableField(exist = false) //不会与表中字段做映射
    private Department department;

    @TableField(exist = false) //不会与表中字段做映射
    private Salary salary;

}
