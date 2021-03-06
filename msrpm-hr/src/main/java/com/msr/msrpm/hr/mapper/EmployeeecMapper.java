package com.msr.msrpm.hr.mapper;

import com.msr.msrpm.hr.entity.Department;
import com.msr.msrpm.hr.entity.Employeeec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface EmployeeecMapper extends BaseMapper<Employeeec> {
    @Select("select name from employee where id = #{Id}")
    public String getNameById(Integer Id);
    @Select("select name from department where id = #{depId}")
    public String getDepNameById(Integer depId);
    @Select("select * from department")
    public List<Department> getAllDepName();
}
