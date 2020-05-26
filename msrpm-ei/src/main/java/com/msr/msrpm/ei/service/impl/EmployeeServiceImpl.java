package com.msr.msrpm.ei.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.ei.entity.Department;
import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.entity.vo.EmployeeInfoForm;
import com.msr.msrpm.ei.listener.EmployeeListener;
import com.msr.msrpm.ei.mapper.DepartmentMapper;
import com.msr.msrpm.ei.mapper.EmployeeMapper;
import com.msr.msrpm.ei.query.EmployeeQuery;
import com.msr.msrpm.ei.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.servicebase.exception.MSRException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
    @Autowired(required = false)
    private DepartmentMapper departmentMapper;
    @Override
    public void pageQuery(Page<Employee> pageParam, EmployeeQuery employeeQuery) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

        if (employeeQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String name = employeeQuery.getName();
        String workID = employeeQuery.getWorkID();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        if (!StringUtils.isEmpty(workID) ) {
            queryWrapper.eq("workID", workID);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll(){
        return employeeMapper.getAll();
    }

    @Override
    public List<Department> getAllDep(){

        return employeeMapper.getAllDep();
    }

    /**
     * 统计员工男女人数 張家興
     * @return
     */
    @Override
    public List<Map<String, Object>> getGenderCountOfEmp() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("gender as name","count(*) value")
                .groupBy("gender");
        List<Map<String, Object>> maps = baseMapper.selectMaps(queryWrapper);
        return maps;
    }

    /**
     * 统计部门员工数
     * @return
     */
    @Override
    public List<Map<String, Object>> getDeCountOfEmp() {
        return baseMapper.getDeCountOfEmp();
    }

    /**
     * 统计员工最高学历
     * @return
     */
    @Override
    public List<Map<String, Object>> getDegreeCountOfEmp() {
        return baseMapper.getDegreeCountOfEmp();
    }

    /**
     * 统计员工职位
     * @return
     */
    @Override
    public List<Map<String, Object>> getPositionCountOfEmp() {
        return baseMapper.getPositionCountOfEmp();
    }

    @Override
    public List<Map<String, Object>> getGenderCountOfDepartment() {
        return baseMapper.getGenderCountOfDepartment();
    }

    //统计职位的男女人数
    @Override
    public List<Map<String, Object>> getPositionGenderCountOfEmp() {
        return baseMapper.getPositionGenderCountOfEmp();
    }
}
