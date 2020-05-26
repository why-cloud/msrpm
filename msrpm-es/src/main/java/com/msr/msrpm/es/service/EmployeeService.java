package com.msr.msrpm.es.service;

import com.msr.msrpm.es.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
