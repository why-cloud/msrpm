package com.msr.msrpm.tm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.tm.entity.Temperature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.msrpm.tm.vo.TemperatureVo;
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
public interface TemperatureMapper extends BaseMapper<Temperature> {


    List<TemperatureVo> getTemperature(Page<TemperatureVo> page);

}
