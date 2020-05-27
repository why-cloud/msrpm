package com.msr.msrpm.hr.controller;


import com.msr.common.utils.PageUtils;
import com.msr.common.utils.R1;
import com.msr.msrpm.hr.entity.Employeeec;
import com.msr.msrpm.hr.service.EmployeeecService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Api(description = "员工奖惩")
@CrossOrigin
@RestController
@RequestMapping("/hr/employeeec")
public class EmployeeecController {
    @Autowired
    private EmployeeecService employeeecService;
    @RequestMapping("/deps")
    public R1 listDep(){
        System.out.println(employeeecService.getDepList());
        return R1.ok().put("dep",employeeecService.getDepList());
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hr:employeeec:list")
    public R1 list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeecService.queryPage(params);
        System.out.println(page.getList());
        return R1.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hr:employeeec:info")
    public R1 info(@PathVariable("id") Integer id){
        Employeeec employeeec = employeeecService.getById(id);

        return R1.ok().put("employeeec", employeeec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hr:employeeec:save")
    public R1 save(@RequestBody Employeeec employeeec){
        employeeecService.save(employeeec);

        return R1.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hr:employeeec:update")
    public R1 update(@RequestBody Employeeec employeeec){
        employeeecService.updateById(employeeec);

        return R1.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hr:employeeec:delete")
    public R1 delete(@RequestBody Integer[] ids){
        employeeecService.removeByIds(Arrays.asList(ids));

        return R1.ok();
    }

}

