package com.msr.msrpm.es.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.es.EmpsalaryQuery;
import com.msr.msrpm.es.entity.Empsalary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.msrpm.es.vo.SalarySobVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface EmpsalaryService extends IService<Empsalary> {



    //Page<Empsalary> getEmpsalary(Page<Empsalary> Page);

   // void pageQuery(Page<Empsalary> pageParam, EmpsalaryQuery empsalaryQuery);

    //Page<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page EmpsalaryQuery empsalaryQuery);

    void updateEmpsalaryInfoById(Empsalary empsalary);

    Page<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page, EmpsalaryQuery empsalaryQuery);


    //List<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page);

    // Page<Empsalary> getEmp(Page<Object> objectPage);

     //Page<Empsalary> getEmp(Page<Empsalary> Page);
}
