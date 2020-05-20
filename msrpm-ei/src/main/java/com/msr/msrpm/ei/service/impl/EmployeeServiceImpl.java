package com.msr.msrpm.ei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.mapper.EmployeeMapper;
import com.msr.msrpm.ei.query.EmployeeQuery;
import com.msr.msrpm.ei.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public void pageQuery(Page<Employee> pageParam, EmployeeQuery employeeQuery) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("workID");

        if (employeeQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String name = employeeQuery.getName();
        String workID = employeeQuery.getWorkID();
        String begin = employeeQuery.getBegin();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        if (!StringUtils.isEmpty(workID) ) {
            queryWrapper.eq("level", workID);
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("beginDate", begin);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployee(){
        return employeeMapper.getEmployee();
    }
    @Override
    public List<Employee> getAll(){
        return employeeMapper.getAll();
    }


}
