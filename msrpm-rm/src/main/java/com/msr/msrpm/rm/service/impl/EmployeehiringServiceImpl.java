package com.msr.msrpm.rm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Employeehiring;
import com.msr.msrpm.rm.entity.Resume;
import com.msr.msrpm.rm.mapper.EmployeehiringMapper;
import com.msr.msrpm.rm.query.HiringQuery;
import com.msr.msrpm.rm.service.EmployeehiringService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class EmployeehiringServiceImpl extends ServiceImpl<EmployeehiringMapper, Employeehiring> implements EmployeehiringService {

    @Override
    public boolean removeById(String id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }
    @Autowired
    EmployeehiringMapper employeehiringMapper;

    @Override
    public Page<Employeehiring> getEmployeeHiring(Page<Employeehiring> page,HiringQuery hiringQuery) {
        QueryWrapper<Employeehiring> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

        String name = hiringQuery.getName();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        return page.setRecords(this.employeehiringMapper.getEmployeeHiring(page,hiringQuery));
    }

//    @Override
//    public void hiringQuery(Page<Employeehiring> pageParam, HiringQuery hiringQuery) {
//        QueryWrapper<Employeehiring> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByAsc("id");
//
//        if (hiringQuery == null){
//            baseMapper.selectPage(pageParam, queryWrapper);
//            return;
//        }
//
//        String name = hiringQuery.getName();
//
//        if (!StringUtils.isEmpty(name)) {
//            queryWrapper.like("name", name);
//        }
//        baseMapper.selectPage(pageParam, queryWrapper);
//
//    }



}
