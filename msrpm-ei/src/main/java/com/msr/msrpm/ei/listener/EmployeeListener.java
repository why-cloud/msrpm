package com.msr.msrpm.ei.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.service.EmployeeService;
import com.msr.servicebase.exception.MSRException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListener extends AnalysisEventListener<Employee> {
    public EmployeeService employeeService;
    List<Employee> list = new ArrayList<Employee>();
    public EmployeeListener(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public void invoke(Employee employeeData, AnalysisContext analysisContext) {
        list.add(employeeData);
        if (employeeData == null) {
            throw new MSRException(20001, "文件数据为空");
        }
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}
