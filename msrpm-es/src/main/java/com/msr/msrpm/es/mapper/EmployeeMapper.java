package com.msr.msrpm.es.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.es.EmployeeQuery;
import com.msr.msrpm.es.EmpsalaryQuery;
import com.msr.msrpm.es.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.msrpm.es.vo.SalarySobVo;
import feign.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-20
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    //Employee getById(Integer id);
    Employee getByName(String name);

    List<SalarySobVo> getName(Page<SalarySobVo> page,  EmployeeQuery employeeQuery);

   // List<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page, @Param("emp") EmpsalaryQuery empsalaryQuery);


}
