package com.msr.msrpm.es.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.es.EmployeeQuery;
import com.msr.msrpm.es.EmpsalaryQuery;
import com.msr.msrpm.es.entity.Employee;
import com.msr.msrpm.es.entity.Empsalary;
import com.msr.msrpm.es.service.EmployeeService;
import com.msr.msrpm.es.service.EmpsalaryService;
import com.msr.msrpm.es.vo.SalarySobVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-20
 */
@CrossOrigin //跨域
@RestController
@RequestMapping("/es/employee")
//@RequestMapping(value = "/getByName/{name}",method = RequestMethod.GET)
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @ApiOperation(value = "根据姓名查询账套")
    @GetMapping("employee-info/{name}")
    public R getByName(
            @ApiParam(name = "name", value = "员工姓名", required = true)
            @PathVariable String name){
        Employee employee = employeeService.getByName(name);
        //Employee employee = employeeService.getById(id);
        return R.ok().data("employee",employee);
    }


    @ApiOperation(value = "多表分页查询")
    @GetMapping("{page}/{limit}")
    public R getName(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "employeeQuery", value = "查询对象", required = false)
                    EmployeeQuery employeeQuery

    ){


        Page<SalarySobVo> pageParam = employeeService.getName(new Page<>(page, limit),employeeQuery);

//        empsalaryService.pageQuery(pageParam,empsalaryQuery);

        List<SalarySobVo> records = pageParam.getRecords();

        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);


    }


    /*
    * @ApiOperation(value = "根据用户信息查询")
    @GetMapping
    public R getUserAndAddressAndOrder(
            ){

        List<User> users = userService.getUserAndAddressAndOrder();
        return R.ok().data("users", users);

    }
    * */

}

