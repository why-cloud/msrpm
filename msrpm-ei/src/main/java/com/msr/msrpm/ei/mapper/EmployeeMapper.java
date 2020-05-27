package com.msr.msrpm.ei.mapper;

import com.msr.msrpm.ei.entity.Department;
import com.msr.msrpm.ei.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    //统计部门员工数
    @Select("SELECT department.name , count(*) value  FROM  employee, department where   employee.departmentId = department.id  group BY departmentId")
    List<Map<String, Object>> getDeCountOfEmp();
    //统计员工最高学历
    @Select("SELECT tiptopdegree.name as name , COUNT(*) value  FROM  employee, tiptopdegree WHERE   employee.degreeId = tiptopdegree.id  GROUP BY degreeId")
    List<Map<String, Object>> getDegreeCountOfEmp();
    //统计员工职位数
    @Select("SELECT position.name , COUNT(*) value  FROM  employee, position WHERE   employee.posId = position.id  GROUP BY posId")
    List<Map<String, Object>> getPositionCountOfEmp();
    //统计各部门的男女人数
    @Select("SELECT department.name ,\n" +
            "SUM(CASE WHEN gender = '男' THEN 1 ELSE 0 END) AS man,\n" +
            "SUM(CASE WHEN gender = '女' THEN 1 ELSE 0 END) AS woman,\n" +
            " count(*) value  FROM  employee, department where   employee.departmentId = department.id  group BY departmentId")
    List<Map<String, Object>> getGenderCountOfDepartment();

    /**
     * 统计职位的男女人数
     * @return
     */
    @Select("SELECT position.name ,\n" +
            "SUM(CASE WHEN gender = '男' THEN 1 ELSE 0 END) AS man,\n" +
            "SUM(CASE WHEN gender = '女' THEN 1 ELSE 0 END) AS woman,\n" +
            "count(*) value  FROM  employee,position where   employee.posId = position.id  group BY posId")
    List<Map<String, Object>> getPositionGenderCountOfEmp();

    @Select("select * from employee")
    public List<Employee> employeeinfo();
}
