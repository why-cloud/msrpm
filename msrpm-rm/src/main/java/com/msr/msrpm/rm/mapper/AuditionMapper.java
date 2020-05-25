package com.msr.msrpm.rm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Audition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.msrpm.rm.vo.AuditionPositionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Repository
public interface AuditionMapper extends BaseMapper<Audition> {

    List<AuditionPositionVo> getResumePosition(Page<AuditionPositionVo> page);
}
