package com.msr.msrpm.rm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Audition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.rm.vo.AuditionPositionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface AuditionService extends IService<Audition> {
    boolean removeById(String id);

    Page<AuditionPositionVo> getAuditionPosition(Page<AuditionPositionVo> page);
}
