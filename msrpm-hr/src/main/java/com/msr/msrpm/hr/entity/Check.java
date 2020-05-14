package com.msr.msrpm.hr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author msr
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Check对象", description="")
public class Check implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @ApiModelProperty(value = "本月天数")
    private Integer daysMonth;

    @ApiModelProperty(value = "公休假天数")
    private Integer daysHolidays;

    @ApiModelProperty(value = "应出勤天数")
    private Integer daysDuty;

    @ApiModelProperty(value = "请假天数")
    private Integer daysLeave;

    @ApiModelProperty(value = "节假日加班")
    private Integer holidayOvertime;

    @ApiModelProperty(value = "日常加班")
    @TableField("Daily_overtime")
    private Integer dailyOvertime;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}
