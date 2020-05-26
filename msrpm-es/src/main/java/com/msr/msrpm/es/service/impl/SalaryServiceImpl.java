package com.msr.msrpm.es.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.es.EmpsalaryQuery;
import com.msr.msrpm.es.SalaryQuery;
import com.msr.msrpm.es.entity.Salary;
import com.msr.msrpm.es.mapper.SalaryMapper;
import com.msr.msrpm.es.service.SalaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.servicebase.exception.MSRException;
import org.springframework.beans.BeanUtils;
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
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements SalaryService {

    @Override
    public void pageQuery(Page<Salary> pageParam, SalaryQuery salaryQuery) {
        QueryWrapper<Salary> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

        if (salaryQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String name = salaryQuery.getName();
        Integer id = salaryQuery.getId();
         String begin = SalaryQuery.getBegin();
          String end = SalaryQuery.getEnd();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        if (!StringUtils.isEmpty(id) ) {
            queryWrapper.eq("id", id);
        }

       if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }



    @Override
    public Integer saveSalaryInfo(Salary salary) {
        //保存账套信息
        Salary salary01 = new Salary();
        //salary01.setStatus(Salary.COURSE_DRAFT);
        BeanUtils.copyProperties(salary,salary01);
        boolean resultSalary = this .save(salary01);
        if(!resultSalary){
            throw new MSRException(20001,"账套信息保存失败");
        }
        //保存课程详情信息
       /* EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        boolean resultDescription = courseDescriptionService.save(courseDescription);
        if (!resultDescription){
            throw new MSRException(20001, "账套详情信息保存失败");
        }*/

        return salary01.getId();
    }

    @Override
    public void updateSalaryInfoById(Salary salary) {
        //保存账套基本信息
        Salary salary02 = new Salary();
        BeanUtils.copyProperties(salary,salary02);
        boolean resultSalary = this.updateById(salary02);
        if (!resultSalary){
            throw  new MSRException(20001,"账套信息保存失败");
        }

        /*//保存课程基本信息
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,course);
        boolean resultCourseInfo = this.updateById(course);
        if (!resultCourseInfo){
            throw  new MSRException(20001,"课程信息保存失败");
        }
        //保存课程详情信息
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        boolean resultDescription = courseDescriptionService.updateById(courseDescription);
        if(!resultDescription){
            throw new MSRException(20001, "课程详情信息保存失败");
        }*/
    }



}
