package com.msr.msrpm.hr.service;

import com.msr.common.utils.PageUtils;
import com.msr.msrpm.hr.entity.Employeeremove;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface EmployeeremoveService extends IService<Employeeremove> {
    PageUtils queryPage(Map<String, Object> params);
}
