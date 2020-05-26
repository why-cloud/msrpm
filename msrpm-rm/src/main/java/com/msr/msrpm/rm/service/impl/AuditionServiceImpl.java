package com.msr.msrpm.rm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Audition;
import com.msr.msrpm.rm.mapper.AuditionMapper;
import com.msr.msrpm.rm.service.AuditionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.msrpm.rm.vo.AuditionPositionVo;
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
public class AuditionServiceImpl extends ServiceImpl<AuditionMapper, Audition> implements AuditionService {

    @Override
    public boolean removeById(String id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }

    @Autowired
    AuditionMapper auditionMapper;

    @Override
    public Page<AuditionPositionVo> getAuditionPosition(Page<AuditionPositionVo> page) {
        return page.setRecords(this.auditionMapper.getResumePosition(page));
    }
}
