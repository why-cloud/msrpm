package com.msr.msrpm.ei.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.ei.entity.Department;
import com.msr.msrpm.ei.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.ei.query.EmployeeQuery;


import java.util.List;
import java.util.Map;


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
 public List<Department> getAllDep();

 /**
  * 统计员工男女人数 張家興
  * @return
  */
 List<Map<String, Object>> getGenderCountOfEmp();

 List<Map<String, Object>> getDeCountOfEmp();

 List<Map<String, Object>> getDegreeCountOfEmp();

 List<Map<String, Object>> getPositionCountOfEmp();

 List<Map<String, Object>> getGenderCountOfDepartment();

 List<Map<String, Object>> getPositionGenderCountOfEmp();
}
