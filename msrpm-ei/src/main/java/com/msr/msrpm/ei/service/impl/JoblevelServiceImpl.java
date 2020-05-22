package com.msr.msrpm.ei.service.impl;

import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.entity.Joblevel;
import com.msr.msrpm.ei.mapper.EmployeeMapper;
import com.msr.msrpm.ei.mapper.JoblevelMapper;
import com.msr.msrpm.ei.service.JoblevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class JoblevelServiceImpl extends ServiceImpl<JoblevelMapper, Joblevel> implements JoblevelService {
@Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAll(){
    return employeeMapper.getAll();
}
}
