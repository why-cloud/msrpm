package com.msr.msrpm.es.mapper;

import com.msr.msrpm.es.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-20
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    //Employee getById(Integer id);
    Employee getByName(String name);
}
