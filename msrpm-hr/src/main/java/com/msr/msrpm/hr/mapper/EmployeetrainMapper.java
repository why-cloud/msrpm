package com.msr.msrpm.hr.mapper;

import com.msr.msrpm.hr.entity.Employeetrain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface EmployeetrainMapper extends BaseMapper<Employeetrain> {
    @Select("select name from employee where id = #{Id}")
    public String getNameById(Integer Id);
}
