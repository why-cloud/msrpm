package com.msr.msrpm.tm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.tm.entity.Temperature;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.tm.vo.TemperatureVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface TemperatureService extends IService<Temperature> {
    void pageQuery(Page<Temperature> pageParam, Temperature temperatureQuery);
    boolean removeById(Integer id);


    Page<TemperatureVo> getTemperature(Page<TemperatureVo> page);

}
