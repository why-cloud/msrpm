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

import java.util.List;
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
        for(int i = 0;i<page.getRecords().size();i++){
            Employeeremove employeeremove = page.getRecords().get(i);
            employeeremove.setName(baseMapper.getNameById(employeeremove.getId()));
            employeeremove.setAfterDepName(baseMapper.getDepNameById(employeeremove.getAfterDepId()));
            employeeremove.setAfterJobName(baseMapper.getJobNameById(employeeremove.getAfterJobId()));
            employeeremove.setBeforeDepName(baseMapper.getDepNameById(employeeremove.getBeforeDepId()));
            employeeremove.setBeforeJobName(baseMapper.getJobNameById(employeeremove.getBeforeJobId()));
        }
        return new PageUtils(page);
    }

    @Override
    public Map<Integer,String> getDepList() {
        return baseMapper.getAllDepName();
    }

    @Override
    public Map<Integer,String> getJobList() {
        return baseMapper.getAllJobName();
    }


}
