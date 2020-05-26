package com.msr.msrpm.es;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SalaryQuery {

    @ApiModelProperty(value = "名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private static String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private static String end;

    public static String getBegin() {return begin;
    }

    public String getName() {
        return this.name;
    }
    public Integer getId() {
        return this.id;
    }
    /*public String getBegin() {
        return this.begin;
    }*/
    public static String getEnd() {
        return end;
    }

}
