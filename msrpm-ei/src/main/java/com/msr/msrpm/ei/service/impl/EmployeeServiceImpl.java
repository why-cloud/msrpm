package com.msr.msrpm.ei.service.impl;

import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.mapper.EmployeeMapper;
import com.msr.msrpm.ei.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-14
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
