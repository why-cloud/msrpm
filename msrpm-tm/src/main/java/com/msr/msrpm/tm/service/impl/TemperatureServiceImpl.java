package com.msr.msrpm.tm.service.impl;

import com.msr.msrpm.tm.entity.Temperature;
import com.msr.msrpm.tm.mapper.TemperatureMapper;
import com.msr.msrpm.tm.service.TemperatureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class TemperatureServiceImpl extends ServiceImpl<TemperatureMapper, Temperature> implements TemperatureService {

}
