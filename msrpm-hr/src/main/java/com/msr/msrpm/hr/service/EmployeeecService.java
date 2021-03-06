package com.msr.msrpm.hr.service;

import com.msr.common.utils.PageUtils;
import com.msr.msrpm.hr.entity.Department;
import com.msr.msrpm.hr.entity.Employeeec;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface EmployeeecService extends IService<Employeeec> {
    PageUtils queryPage(Map<String, Object> params);
    List<Department> getDepList();
}
