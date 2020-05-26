package com.msr.msrpm.rm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Resume;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.rm.query.ResumeQuery;
import com.msr.msrpm.rm.vo.ResumePositionVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface ResumeService extends IService<Resume> {
    boolean removeById(String id);

    void pageQuery(Page<Resume> pageParam, ResumeQuery resumeQuery);

    //Page<ResumePositionVo> getResumePosition(Page<ResumePositionVo> page);
}
