package com.msr.msrpm.hr.controller;


import com.msr.common.utils.PageUtils;
import com.msr.common.utils.R1;
import com.msr.msrpm.hr.entity.Employeetrain;
import com.msr.msrpm.hr.service.EmployeetrainService;
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
@Api(description = "员工培训")
@CrossOrigin
@RestController
@RequestMapping("/hr/employeetrain")
public class EmployeetrainController {
    @Autowired
    private EmployeetrainService employeetrainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hr:employeetrain:list")
    public R1 list(@RequestParam Map<String, Object> params){
        PageUtils page = employeetrainService.queryPage(params);
        System.out.println(page.getList());
        return R1.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hr:employeetrain:info")
    public R1 info(@PathVariable("id") Integer id){
        Employeetrain employeetrain = employeetrainService.getById(id);

        return R1.ok().put("employeetrain", employeetrain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hr:employeetrain:save")
    public R1 save(@RequestBody Employeetrain employeetrain){
        employeetrainService.save(employeetrain);
        System.out.println(employeetrain);
        return R1.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hr:employeetrain:update")
    public R1 update(@RequestBody Employeetrain employeetrain){
        employeetrainService.updateById(employeetrain);

        return R1.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hr:employeetrain:delete")
    public R1 delete(@RequestBody Integer[] ids){
        employeetrainService.removeByIds(Arrays.asList(ids));

        return R1.ok();
    }
}

