package com.msr.msrpm.hr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msr.common.utils.PageUtils;
import com.msr.common.utils.Query;
import com.msr.msrpm.hr.entity.Employeeremove;
import com.msr.msrpm.hr.mapper.EmployeeremoveMapper;
import com.msr.msrpm.hr.service.EmployeeremoveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service("employeeremoveService")
public class EmployeeremoveServiceImpl extends ServiceImpl<EmployeeremoveMapper, Employeeremove> implements EmployeeremoveService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Employeeremove> page = this.page(
                new Query<Employeeremove>().getPage(params),
                new QueryWrapper<Employeeremove>()
        );

        return new PageUtils(page);
    }
}
