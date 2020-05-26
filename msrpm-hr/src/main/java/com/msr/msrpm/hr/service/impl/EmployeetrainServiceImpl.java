package com.msr.msrpm.hr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msr.common.utils.PageUtils;
import com.msr.common.utils.Query;
import com.msr.msrpm.hr.entity.Employcheck;
import com.msr.msrpm.hr.entity.Employeeremove;
import com.msr.msrpm.hr.entity.Employeetrain;
import com.msr.msrpm.hr.mapper.EmployeetrainMapper;
import com.msr.msrpm.hr.service.EmployeetrainService;
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
@Service
public class EmployeetrainServiceImpl extends ServiceImpl<EmployeetrainMapper, Employeetrain> implements EmployeetrainService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<Employeetrain> queryWrapper = new QueryWrapper();
        Object train = params.get("key");
        queryWrapper.like("train_content",train);
        IPage<Employeetrain> page = this.page(
                new Query<Employeetrain>().getPage(params),
                queryWrapper
        );
        for(int i = 0;i<page.getRecords().size();i++){
            Employeetrain employeetrain = page.getRecords().get(i);
            employeetrain.setName(baseMapper.getNameById(employeetrain.getId()))
            ;}
        return new PageUtils(page);
    }
}
