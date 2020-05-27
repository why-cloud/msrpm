package com.msr.msrpm.es;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmployeeQuery {


    @ApiModelProperty(value = "名称,模糊查询")
    private String name;


}
