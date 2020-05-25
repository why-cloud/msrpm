package com.msr.msrpm.rm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Employeehiring;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.msrpm.rm.vo.EmployeehiringVo;
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
    List<EmployeehiringVo> getEmployeeHiring(@Param("page") Page<EmployeehiringVo> page, @Param("emp") EmployeehiringVo employeehiringVo);
    //List<EmployeehiringVo> getEmployeeHiring(@Param("page") Long page, @Param("size") Integer size, @Param("emp") EmployeehiringVo employeehiringVo);
    //@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee

    //List<EmployeehiringVo> getEmployeeHiring(Page<EmployeehiringVo> page);
}
