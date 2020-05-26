package com.msr.msrpm.es.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.es.EmpsalaryQuery;
import com.msr.msrpm.es.SalaryQuery;
import com.msr.msrpm.es.entity.Salary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface SalaryService extends IService<Salary> {
    void pageQuery(Page<Salary> pageParam, SalaryQuery salaryQuery);

    Integer saveSalaryInfo(Salary salary);

    void updateSalaryInfoById(Salary salary);
    //void getById(Salary salary);
}
