package com.msr.msrpm.es.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.es.EmployeeQuery;
import com.msr.msrpm.es.EmpsalaryQuery;
import com.msr.msrpm.es.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.es.vo.SalarySobVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-20
 */
public interface EmployeeService extends IService<Employee> {

    //Employee getById(Integer id);
    Employee getByName(String name);

    Page<SalarySobVo> getName(Page<SalarySobVo> page, EmployeeQuery employeeQuery);
    //Page<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page, EmpsalaryQuery empsalaryQuery);
}
