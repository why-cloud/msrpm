package com.msr.msrpm.ei.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Employee查询对象", description = "员工查询对象封装")
@Data
public class EmployeeQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工姓名，模糊查询")
    private String name;

    @ApiModelProperty(value = "员工工号")
    private String workID;

    @ApiModelProperty(value = "入职日期", example = "2019-01-01")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
}
