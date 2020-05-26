package com.msr.msrpm.rm.query;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel(value = "resume查询对象", description = "查询对象封装")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HiringQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;
}
