package com.msr.msrpm.hr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.msrpm.hr.entity.Department;
import com.msr.msrpm.hr.entity.Employcheck;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 
 * 
 * @author tom
 * @email tom@gmail.com
 * @date 2020-05-18 15:57:36
 */
//@Mapper
public interface EmploycheckMapper extends BaseMapper<Employcheck> {
    @Select("select name from employee where id = #{Id}")
    public String getNameById(Integer Id);
//    @Select("select name from department where id = #{depId}")
//    public String getDepNameById(Integer depId);
//    @Select("select * from department")
//    public List<Department> getAllDepName();
}
