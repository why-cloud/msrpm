package com.msr.msrpm.ei.mapper;

import com.msr.msrpm.ei.entity.Department;
import com.msr.msrpm.ei.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
    public List<Employee> getAll();
    public List<Department> getAllDep();
}
