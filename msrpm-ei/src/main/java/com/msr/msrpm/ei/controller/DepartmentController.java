package com.msr.msrpm.ei.controller;



import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Department;
import com.msr.msrpm.ei.entity.Employee;
import com.msr.msrpm.ei.service.DepartmentService;
import io.swagger.annotations.Api;
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
 * @since 2020-05-18
 */
@CrossOrigin //跨域
@Api(description="部门资料")
@RestController
@RequestMapping("/ei/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @ApiOperation(value = "根据ID查询部门名字")
    @GetMapping("list")
    public R list(){
        List<Department> list = departmentService.getAllDep();
        return R.ok().data("department",list);
    }

}

