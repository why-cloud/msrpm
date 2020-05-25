package com.msr.msrpm.hr.service.impl;

import com.msr.msrpm.hr.entity.Employcheck;
import com.msr.msrpm.hr.mapper.EmploycheckMapper;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.common.utils.PageUtils;
import com.msr.common.utils.Query;

import com.msr.msrpm.hr.service.EmploycheckService;


@Service("employcheckService")
public class EmploycheckServiceImpl extends ServiceImpl<EmploycheckMapper, Employcheck> implements EmploycheckService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Employcheck> page = this.page(
                new Query<Employcheck>().getPage(params),
                new QueryWrapper<Employcheck>()
        );

        return new PageUtils(page);
    }

}