package com.msr.msrpm.rm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Employeehiring;
import com.msr.msrpm.rm.mapper.EmployeehiringMapper;
import com.msr.msrpm.rm.service.EmployeehiringService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.msrpm.rm.vo.EmployeehiringVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Page<EmployeehiringVo> getEmployeeHiring(Page<EmployeehiringVo> page, EmployeehiringVo employeehiringVo) {
        return page.setRecords(this.employeehiringMapper.getEmployeeHiring(page,employeehiringVo));
    }


//    @Override
//    public Page<EmployeehiringVo> getEmployeeHiring(Page<EmployeehiringVo> page) {
//        return page.setRecords(this.employeehiringMapper.getEmployeeHiring(page));
//    }
}
