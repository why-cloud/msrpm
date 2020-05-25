package com.msr.msrpm.rm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Resume;
import com.msr.msrpm.rm.mapper.ResumeMapper;
import com.msr.msrpm.rm.query.ResumeQuery;
import com.msr.msrpm.rm.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.msrpm.rm.vo.ResumePositionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
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
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements ResumeService {

    @Override
    public void pageQuery(Page<Resume> pageParam, ResumeQuery resumeQuery) {

        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

        if (resumeQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String rname = resumeQuery.getRname();
        Integer appliPosid = resumeQuery.getAppliPosid();
        String begin = resumeQuery.getBegin();
        String end = resumeQuery.getEnd();

        if (!StringUtils.isEmpty(rname)) {
            queryWrapper.like("rname", rname);
        }

        if (!StringUtils.isEmpty(appliPosid) ) {
            queryWrapper.eq("appli_posId",appliPosid );
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }



//    @Override
//    public List<Resume> selectByMap(String name) {
//        List<Resume> resumeList = baseMapper.selectByMap()
//        return resumeList;
//    }


    @Override
    public boolean removeById(String id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }



    @Autowired
    private ResumeMapper resumeMapper;


//    @Override
//    public Page<ResumePositionVo> getResumePosition(Page<ResumePositionVo> page) {
//
//        return page.setRecords(this.resumeMapper.getResumePosition(page));
//    }


}
