package com.msr.msrpm.ei.service;

import com.msr.msrpm.ei.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */

public interface DepartmentService extends IService<Department> {
   public List<Department> getAllDep();

}
