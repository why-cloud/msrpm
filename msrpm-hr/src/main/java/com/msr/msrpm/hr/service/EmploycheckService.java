package com.msr.msrpm.hr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.common.utils.PageUtils;
import com.msr.msrpm.hr.entity.Employcheck;

import java.util.Map;

/**
 * 
 *
 * @author tom
 * @email tom@gmail.com
 * @date 2020-05-18 15:57:36
 */
public interface EmploycheckService extends IService<Employcheck> {
    PageUtils queryPage(Map<String, Object> params);
}

