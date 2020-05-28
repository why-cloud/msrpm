package com.msr.msrpm.ei.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.msr.msrpm.ei.entity.excel.EmployeeData;
import com.msr.msrpm.ei.service.EmployeeService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

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
@ApiModel(value="Employee对象", description="Employee entity")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value="员工ID",index=0)
    @ApiModelProperty(value = "员工编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ExcelProperty(value = "员工姓名",index = 1)
    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ExcelProperty(value = "性别",index = 2)
    @ApiModelProperty(value = "性别")
    private String gender;

    @ExcelProperty(value = "出生日期",index = 3)
    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ExcelProperty(value = "身份证号",index = 4)
    @ApiModelProperty(value = "身份证号")
    @TableField("idCard")
    private String idCard;

    @ExcelProperty(value = "婚姻状况",index = 5)
    @ApiModelProperty(value = "婚姻状况")
    private String wedlock;

    @ExcelProperty(value = "民族",index = 6)
    @ApiModelProperty(value = "民族")
    @TableField("nationId")
    private Integer nationId;

    @ExcelProperty(value = "籍贯",index = 7)
    @ApiModelProperty(value = "籍贯")
    @TableField("nativePlace")
    private String nativePlace;

    @ExcelProperty(value = "政治面貌",index = 8)
    @ApiModelProperty(value = "政治面貌")
    @TableField("politicId")
    private Integer politicId;

    @ExcelProperty(value = "邮箱",index = 9)
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "电话号码",index = 10)
    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ExcelProperty(value = "联系地址",index = 11)
    @ApiModelProperty(value = "联系地址")
    private String address;

    @ExcelProperty(value = "所属部门",index = 12)
    @ApiModelProperty(value = "所属部门")
    @TableField("departmentId")
    private Integer departmentId;

    @ExcelProperty(value = "职称ID",index = 13)
    @ApiModelProperty(value = "职称ID")
    @TableField("jobLevelId")
    private Integer jobLevelId;

    @ExcelProperty(value = "职位ID",index = 14)
    @ApiModelProperty(value = "职位ID")
    @TableField("posId")
    private Integer posId;

    @ExcelProperty(value = "合同形式",index = 15)
    @ApiModelProperty(value = "合同形式")
    @TableField("formId")
    private Integer formId;

    @ExcelProperty(value = "最高学历",index = 16)
    @ApiModelProperty(value = "最高学历")
    @TableField("degreeId")
    private Integer degreeId;

    @ExcelProperty(value = "所属专业",index = 17)
    @ApiModelProperty(value = "所属专业")
    private String specialty;

    @ExcelProperty(value = "毕业院校",index = 18)
    @ApiModelProperty(value = "毕业院校")
    private String school;

    @ExcelProperty(value = "入职日期",index = 19)
    @ApiModelProperty(value = "入职日期")
    @TableField("beginDate")
    private String beginDate;

    @ExcelProperty(value = "在职状态",index = 20)
    @ApiModelProperty(value = "在职状态")
    @TableField(value = "stateIId" )
    private Integer stateIId;

    @ExcelProperty(value = "工号",index = 21)
    @ApiModelProperty(value = "工号")
    @TableField("workID")
    private String workID;

    @ExcelProperty(value = "合同期限",index = 22)
    @ApiModelProperty(value = "合同期限")
    @TableField("contractTerm")
    private Double contractTerm;

    @ExcelProperty(value = "转正日期",index = 23)
    @ApiModelProperty(value = "转正日期")
    @TableField("conversionTime")
    private String conversionTime;

    @ExcelProperty(value = "离职日期",index = 24)
    @ApiModelProperty(value = "离职日期")
    @TableField("notWorkDate")
    private String notWorkDate;

    @ExcelProperty(value = "合同终止日期",index = 25)
    @ApiModelProperty(value = "合同终止日期")
    @TableField("endContract")
    private String endContract;

    @ExcelProperty(value = "合同起始日期",index = 26)
    @ApiModelProperty(value = "合同起始日期")
    @TableField("beginContract")
    private String beginContract;

    @ExcelProperty(value = "工龄",index =27)
    @ApiModelProperty(value = "工龄")
    @TableField("workAge")
    private Integer workAge;

    @ExcelProperty(value = "是否删除",index =28)
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ExcelProperty(value = "创建时间",index =29)
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ExcelProperty(value = "更新时间",index =30)
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(exist = false)
    private Nation nation;

    @TableField(exist = false)
    private Politicsstatus politicsstatus;

    @TableField(exist = false)
    private Department department;

    @TableField(exist = false)
    private Engageform engageform;

    @TableField(exist = false)
    private Joblevel joblevel;

    @TableField(exist = false)
    private Position position;

    @TableField(exist = false)
    private Tiptopdegree tiptopdegree;

    @TableField(exist = false)
    private Workstate workstate;

}
