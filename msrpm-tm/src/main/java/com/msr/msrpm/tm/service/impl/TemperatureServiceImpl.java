package com.msr.msrpm.tm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.tm.entity.Temperature;
import com.msr.msrpm.tm.mapper.TemperatureMapper;
import com.msr.msrpm.tm.service.TemperatureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.msrpm.tm.vo.TemperatureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    @Override
    public void pageQuery(Page<Temperature> pageParam, Temperature temperatureQuery) {
        QueryWrapper<Temperature> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

    }

    @Override
    public boolean removeById(Integer id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }
    @Autowired
    TemperatureMapper temperatureMapper;

    @Override
    public Page<TemperatureVo> getTemperature(Page<TemperatureVo> page) {
        return page.setRecords(this.temperatureMapper.getTemperature(page));
    }


    @Override
    public boolean saveBatch(Collection<Temperature> entityList) {
        return false;
    }
}
