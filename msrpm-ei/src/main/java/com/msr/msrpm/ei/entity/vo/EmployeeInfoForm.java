package com.msr.msrpm.ei.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "员工基本信息", description = "编辑员工基本信息的表单对象")
@Data
public class EmployeeInfoForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族")
    @TableField("nationId")
    private Integer nationId;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "政治面貌")
    private Integer politicId;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "所属部门")
    @TableField("departmentId")
    private Integer departmentId;

    @ApiModelProperty(value = "职称ID")
    private Integer jobLevelId;

    @ApiModelProperty(value = "职位ID")
    private Integer posId;

    @ApiModelProperty(value = "合同形式")
    private Integer formId;

    @ApiModelProperty(value = "最高学历")
    private Integer degreeId;

    @ApiModelProperty(value = "所属专业")
    private String specialty;

    @ApiModelProperty(value = "毕业院校")
    private String school;

    @ApiModelProperty(value = "入职日期")
    private String beginDate;

    @ApiModelProperty(value = "在职状态")
    private Integer stateIId;

    @ApiModelProperty(value = "工号")
    private String workID;

    @ApiModelProperty(value = "合同期限")
    private Double contractTerm;

    @ApiModelProperty(value = "转正日期")
    private String conversionTime;

    @ApiModelProperty(value = "离职日期")
    private String notWorkDate;

    @ApiModelProperty(value = "合同起始日期")
    private String beginContract;

    @ApiModelProperty(value = "合同终止日期")
    private String endContract;

    @ApiModelProperty(value = "工龄")
    private Integer workAge;


}
