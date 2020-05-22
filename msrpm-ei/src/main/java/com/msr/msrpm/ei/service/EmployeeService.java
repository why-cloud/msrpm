package com.msr.msrpm.ei.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.ei.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.ei.query.EmployeeQuery;


import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */

public interface EmployeeService extends IService<Employee> {
 void pageQuery(Page<Employee> pageParam, EmployeeQuery employeeQuery);
 public List<Employee> getAll();

}
