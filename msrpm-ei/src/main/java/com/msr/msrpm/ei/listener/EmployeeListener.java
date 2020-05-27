package com.msr.msrpm.ei.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.entity.excel.EmployeeData;
import com.msr.msrpm.ei.service.EmployeeService;
import com.msr.servicebase.exception.MSRException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class EmployeeListener extends AnalysisEventListener<Employee> {
    private EmployeeService employeeService;
    public EmployeeListener() {}
    private static final int BATCH_COUNT = 2;
    List<Employee> list = new ArrayList<Employee>(BATCH_COUNT);
    public EmployeeListener(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
    @Override
    public void invoke(Employee employee, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(employee));
        list.add(employee);
        if (list.size() >= BATCH_COUNT) {
            employeeService.save(employee);
            // 存储完成清理 list
            list.clear();
        }
        if (employee == null) {
            throw new MSRException(20001, "文件数据为空");
        }
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        log.info("存储数据库成功！");
        employeeService.saveData(list); //调用 userService 中的 saveData 方法
        }
}
