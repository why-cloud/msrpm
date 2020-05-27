package com.msr.msrpm.rm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Employeehiring;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.msr.msrpm.rm.entity.Resume;
import com.msr.msrpm.rm.query.HiringQuery;
import org.apache.ibatis.annotations.Param;
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
public interface EmployeehiringMapper extends BaseMapper<Employeehiring> {
    List<Employeehiring> getEmployeeHiring(Page<Employeehiring> page, @Param("emp")HiringQuery hiringQuery);

}
