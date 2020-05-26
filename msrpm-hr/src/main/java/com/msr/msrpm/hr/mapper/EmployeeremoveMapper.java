package com.msr.msrpm.hr.mapper;

import com.msr.msrpm.hr.entity.Employeeremove;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface EmployeeremoveMapper extends BaseMapper<Employeeremove> {
    @Select("select name from employee where id = #{Id}")
    public String getNameById(Integer Id);

    @Select("select name from department where id = #{depId}")
    public String getDepNameById(Integer depId);

    @Select("select name from joblevel where id = #{jobId}")
    public String getJobNameById(Integer jobId);

    @Select("select id,name from department")
    public Map<Integer,String> getAllDepName();

    @Select("select id,name from joblevel")
    public Map<Integer,String> getAllJobName();
}
