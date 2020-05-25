package com.msr.msrpm.rm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Employeehiring;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.rm.vo.EmployeehiringVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface EmployeehiringService extends IService<Employeehiring> {
    boolean removeById(String id);

    Page<EmployeehiringVo> getEmployeeHiring(Page<EmployeehiringVo> page, EmployeehiringVo employeehiringVo);


    //Page<EmployeehiringVo> getEmployeeHiring(Page<EmployeehiringVo> page);
}
