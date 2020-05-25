package com.msr.msrpm.hr.controller;


import com.msr.common.utils.PageUtils;
import com.msr.common.utils.R;
import com.msr.common.utils.R1;
import com.msr.msrpm.hr.entity.Employeeremove;
import com.msr.msrpm.hr.service.EmployeeremoveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Api(description = "员工调动")
@CrossOrigin
@RestController
@RequestMapping("/hr/employeeremove")
public class EmployeeremoveController {
    @Autowired
    private EmployeeremoveService employeeremoveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hr:employeeremove:list")
    public R1 list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeremoveService.queryPage(params);
        return R1.ok().put("page", page);
        //put
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hr:employeeremove:info")
    public R1 info(@PathVariable("id") Integer id){
        Employeeremove employeeremove = employeeremoveService.getById(id);
        return R1.ok().put("employeeremove", employeeremove);
        //put
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hr:employeeremove:save")
    public R1 save(@RequestBody Employeeremove employeeremove){
        employeeremoveService.save(employeeremove);
        return R1.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hr:employeeremove:update")
    public R1 update(@RequestBody Employeeremove employeeremove){
        employeeremoveService.updateById(employeeremove);
        return R1.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hr:employeeremove:delete")
    public R delete(@RequestBody Integer[] ids){
        employeeremoveService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

//    @ApiOperation(value = "员工调动信息")
//    @GetMapping
//    public R list(){
//        List<Employeeremove> list = employeeremoveService.list(null);
//        System.out.println(list);
//        return R.ok().data("list",list);
//    }
//
//    @ApiOperation(value = "新增调动记录")
//    @PostMapping
//    public R save(
//            @ApiParam(name = "employeeremove",value = "调动记录",required = true)
//            @RequestBody Employeeremove employeeremove
//    ){
//        employeeremoveService.save(employeeremove);
//        return R.ok();
//    }
}

