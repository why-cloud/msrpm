package com.msr.msrpm.ei.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder
public class EmployeeData extends BaseRowModel {
    @ExcelProperty(value="员工编号",index=0)
    private Integer id;

    @ExcelProperty(value = "员工姓名",index = 1)
    private String name;

    @ExcelProperty(value = "性别",index = 2)
    private String gender;

    @ExcelProperty(value = "出生日期",index = 3)
    private String birthday;

    @ExcelProperty(value = "身份证号",index = 4)
    private String idCard;

    @ExcelProperty(value = "婚姻状况",index = 5)
    private String wedlock;

    @ExcelProperty(value = "民族",index = 6)
    private Integer nationId;

    @ExcelProperty(value = "籍贯",index = 7)
    private String nativePlace;

    @ExcelProperty(value = "政治面貌",index = 8)
    private Integer politicId;

    @ExcelProperty(value = "邮箱",index = 9)
    private String email;

    @ExcelProperty(value = "电话号码",index = 10)
    private String phone;

    @ExcelProperty(value = "联系地址",index = 11)
    private String address;

    @ExcelProperty(value = "所属部门",index = 12)
    private Integer departmentId;

    @ExcelProperty(value = "职称ID",index = 13)
    private Integer jobLevelId;

    @ExcelProperty(value = "职位ID",index = 14)
    private Integer posId;

    @ExcelProperty(value = "合同形式",index = 15)
    private Integer formId;

    @ExcelProperty(value = "最高学历",index = 16)
    private Integer degreeId;

    @ExcelProperty(value = "所属专业",index = 17)
    private String specialty;

    @ExcelProperty(value = "毕业院校",index = 18)
    private String school;

    @ExcelProperty(value = "入职日期",index = 19)
    private String beginDate;

    @ExcelProperty(value = "在职状态",index = 20)
    private Integer stateIId;

    @ExcelProperty(value = "工号",index = 21)
    private String workID;

    @ExcelProperty(value = "合同期限",index = 22)
    private Double contractTerm;

    @ExcelProperty(value = "转正日期",index = 23)
    private String conversionTime;

    @ExcelProperty(value = "离职日期",index = 24)
    private String notWorkDate;

    @ExcelProperty(value = "合同终止日期",index = 25)
    private String endContract;

    @ExcelProperty(value = "合同起始日期",index = 26)
    private String beginContract;

    @ExcelProperty(value = "工龄",index =27)
    private Integer workAge;

    @ExcelProperty(value = "是否删除",index =28)
    private Boolean isDeleted;

    @ExcelProperty(value = "创建时间",index =29)
    private Date gmtCreate;

    @ExcelProperty(value = "更新时间",index =30)
    private Date gmtModified;
}


