package com.msr.msrpm.es.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.es.entity.Empsalary;
import com.msr.msrpm.es.entity.Salary;
import com.msr.msrpm.es.vo.SalarySobVo;
import com.msr.msrpm.es.mapper.EmpsalaryMapper;
import com.msr.msrpm.es.mapper.SalarySobVoMapper;
import com.msr.msrpm.es.service.EmpsalaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.servicebase.exception.MSRException;
import org.springframework.beans.BeanUtils;
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
public class EmpsalaryServiceImpl extends ServiceImpl<EmpsalaryMapper, Empsalary> implements EmpsalaryService {


    private SalarySobVoMapper salarySobVoMapper;

//    @Override
//    public void pageQuery(Page<Empsalary> pageParam, EmpsalaryQuery empsalaryQuery) {
//        QueryWrapper<Empsalary> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByAsc("id");
//
//        if (empsalaryQuery == null){
//            baseMapper.selectPage(pageParam, queryWrapper);
//            return;
//        }
//
//        String name = empsalaryQuery.getName();
//        Integer id = empsalaryQuery.getId();
//       // String begin = teacherQuery.getBegin();
//      //  String end = teacherQuery.getEnd();
//
//        if (!StringUtils.isEmpty(name)) {
//            queryWrapper.like("name", name);
//        }
//
//        if (!StringUtils.isEmpty(id) ) {
//            queryWrapper.eq("id", id);
//        }
//
//       /* if (!StringUtils.isEmpty(begin)) {
//            queryWrapper.ge("gmt_create", begin);
//        }
//
//        if (!StringUtils.isEmpty(end)) {
//            queryWrapper.le("gmt_create", end);
//        }*/
//
//        baseMapper.selectPage(pageParam, queryWrapper);
//    }
@Autowired
EmpsalaryMapper empsalaryMapper;

    @Override
    public Page<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page) {
        return page.setRecords(this.empsalaryMapper.getSalarySobVo(page));
    }

    @Override
    public void updateEmpsalaryInfoById(Empsalary empsalary) {
        //保存账套基本信息
        Empsalary empsalary01 = new Empsalary();
        BeanUtils.copyProperties(empsalary,empsalary01);
        boolean resultEmpsalary = this.updateById(empsalary01);
        if (!resultEmpsalary){
            throw  new MSRException(20001,"账套信息保存失败");
        }
    }



//    @Override
//    public VideoInfoForm getVideoInfoFormById(String id) {
//        //从video表中取数据
//        EduVideo video = this.getById(id);
//        if (video == null){
//            throw new MSRException(20001,"数据不存在");
//        }
//        //创建videoInfoForm对象
//        VideoInfoForm videoInfoForm = new VideoInfoForm();
//        BeanUtils.copyProperties(video,videoInfoForm);
//
//        return videoInfoForm;
//    }



//    @Override
//    public Empsalary getByName(String name) {
//        Empsalary empsalary = this.getByName(name);
//        if(empsalary == null){
//            throw new MSRException(20001,"数据不存在");
//        }
//        //创建empSalary对象
//        Empsalary empsalary01 = new Empsalary();
//        BeanUtils.copyProperties(empsalary,empsalary01);
//        return empsalary01;
//    }


}
