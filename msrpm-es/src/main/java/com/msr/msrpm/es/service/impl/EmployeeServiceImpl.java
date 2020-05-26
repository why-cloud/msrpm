package com.msr.msrpm.es.service.impl;

import com.msr.msrpm.es.entity.Employee;
import com.msr.msrpm.es.entity.Empsalary;
import com.msr.msrpm.es.mapper.EmployeeMapper;
import com.msr.msrpm.es.mapper.EmpsalaryMapper;
import com.msr.msrpm.es.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.servicebase.exception.MSRException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


//    @Override
//    public Employee getById(Integer id) {
//        return employeeMapper.getById(id);
//    }
@Override
public Employee getByName(String name) {
    return employeeMapper.getByName(name);
}

    /*@Override
    public List<User> getUserAndAddressAndOrder() {
        return userMapper.getUserAndAddressAndOrder();
    }*/
/*@Override
    public Page<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page) {
        return page.setRecords(this.empsalaryMapper.getSalarySobVo(page));
    }*/
//    @Override
//    public Employee getByName(String name) {
//        Employee employee = this.getByName(name);
//        if(employee == null){
//            throw new MSRException(20001,"数据不存在");
//        }
//        //创建对象
//        Employee employee01 = new Employee();
//        BeanUtils.copyProperties(employee,employee01);
//        return employee01;
//    }
}
