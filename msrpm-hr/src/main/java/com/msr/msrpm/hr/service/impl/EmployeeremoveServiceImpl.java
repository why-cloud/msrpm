package com.msr.msrpm.hr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msr.common.utils.PageUtils;
import com.msr.common.utils.Query;
import com.msr.msrpm.hr.entity.Department;
import com.msr.msrpm.hr.entity.Employeeremove;
import com.msr.msrpm.hr.entity.Joblevel;
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
        QueryWrapper<Employeeremove> queryWrapper = new QueryWrapper();
        Object reason = params.get("key");
        queryWrapper.like("reason",reason);
        IPage<Employeeremove> page = this.page(
                new Query<Employeeremove>().getPage(params),
                queryWrapper
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
    public List<Department> getDepList() {
        return baseMapper.getAllDepName();
    }

    @Override
    public List<Joblevel> getJobList() {
        return baseMapper.getAllJobName();
    }


}
