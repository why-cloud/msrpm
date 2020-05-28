package com.msr.msrpm.ei.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.entity.excel.EmployeeData;
import com.msr.msrpm.ei.service.EmployeeService;
import com.msr.servicebase.exception.MSRException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Slf4j
public class EmployeeListener extends AnalysisEventListener<Employee> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeListener.class);
    public EmployeeService employeeService;
    private static final int BATCH_COUNT = 100;
    private volatile int totalCount = 0;
    List<Employee> list = new ArrayList<>();
    public EmployeeListener(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public void invoke(Employee data, AnalysisContext context) {
        totalCount ++;
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData(context);
            // 存储完成清理 list
            list.clear();
        }
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData(context);
        LOGGER.info("所有数据解析完成！");
    }
    private void saveData(AnalysisContext context) {
        LOGGER.info("当前正在处理第[{}]行数据，本次处理[{}]条数据,总共有：{}条数据",
                context.readRowHolder().getRowIndex(),list.size(),totalCount);
        // 实际处理逻辑
        employeeService.addBatchEmployee(list);
    }

}
