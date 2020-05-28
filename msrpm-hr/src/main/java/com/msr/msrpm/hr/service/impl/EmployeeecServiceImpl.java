package com.msr.msrpm.hr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msr.common.utils.PageUtils;
import com.msr.common.utils.Query;
import com.msr.msrpm.hr.entity.Department;
import com.msr.msrpm.hr.entity.Employcheck;
import com.msr.msrpm.hr.entity.Employeeec;
import com.msr.msrpm.hr.mapper.EmployeeecMapper;
import com.msr.msrpm.hr.service.EmployeeecService;
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
@Service
public class EmployeeecServiceImpl extends ServiceImpl<EmployeeecMapper, Employeeec> implements EmployeeecService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<Employeeec> queryWrapper = new QueryWrapper();
        Object c = params.get("key");
        queryWrapper.like("ec_reason",c);
        IPage<Employeeec> page = this.page(
                new Query<Employeeec>().getPage(params),
                queryWrapper

        );
        for(int i = 0;i<page.getRecords().size();i++){
            Employeeec employeeec = page.getRecords().get(i);
            employeeec.setName(baseMapper.getNameById(employeeec.getId()));
            employeeec.setDepName(baseMapper.getDepNameById(employeeec.getDepartmentId()));
            if (employeeec.getEcType()==0){
                employeeec.setType("奖");
            }
            if (employeeec.getEcType()==1){
                employeeec.setType("罚");
            }
        }
        return new PageUtils(page);
    }

    @Override
    public List<Department> getDepList() {
        return baseMapper.getAllDepName();
    }

}
