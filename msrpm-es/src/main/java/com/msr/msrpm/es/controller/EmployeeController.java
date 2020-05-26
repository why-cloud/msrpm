package com.msr.msrpm.es.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.es.entity.Employee;
import com.msr.msrpm.es.entity.Empsalary;
import com.msr.msrpm.es.service.EmployeeService;
import com.msr.msrpm.es.service.EmpsalaryService;
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

