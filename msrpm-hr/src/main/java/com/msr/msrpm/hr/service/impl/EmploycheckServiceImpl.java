package com.msr.msrpm.hr.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.hr.entity.Department;
import com.msr.msrpm.hr.entity.Employcheck;
import com.msr.msrpm.hr.mapper.EmploycheckMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.common.utils.PageUtils;
import com.msr.common.utils.Query;

import com.msr.msrpm.hr.service.EmploycheckService;
import org.springframework.util.StringUtils;


@Service("employcheckService")
public class EmploycheckServiceImpl extends ServiceImpl<EmploycheckMapper, Employcheck> implements EmploycheckService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object eid = params.get("key");
        System.out.println(eid);
            QueryWrapper<Employcheck> queryWrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(eid)) {
                queryWrapper.like("eid", eid);
            }
            System.out.println(queryWrapper);
            IPage<Employcheck> page = this.page(
                    new Query<Employcheck>().getPage(params),
                    queryWrapper
            );
            for(int i = 0;i<page.getRecords().size();i++){
                Employcheck employcheck = page.getRecords().get(i);
                employcheck.setName(baseMapper.getNameById(employcheck.getId()));
                //employcheck.setDepName(baseMapper.getDepNameById(employcheck.getId()));
            }
            return new PageUtils(page);
       // }
    }

//    @Override
//    public List<Department> getDepList() {
//        return null;
//    }

}