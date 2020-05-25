package com.msr.msrpm.hr.service;

import com.msr.common.utils.PageUtils;
import com.msr.msrpm.hr.entity.Employeetrain;
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
public interface EmployeetrainService extends IService<Employeetrain> {
    PageUtils queryPage(Map<String, Object> params);
}
