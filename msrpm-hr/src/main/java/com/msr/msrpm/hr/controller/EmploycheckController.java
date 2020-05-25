package com.msr.msrpm.hr.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R1;
import com.msr.msrpm.hr.entity.Employcheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.msr.msrpm.hr.service.EmploycheckService;
import com.msr.common.utils.PageUtils;



/**
 * 
 *
 * @author tom
 * @email tom@gmail.com
 * @date 2020-05-18 15:57:36
 */
@CrossOrigin
@Api(description = "考勤管理")
@RestController
@RequestMapping("/hr/employcheck")
public class EmploycheckController {
    @Autowired
    private EmploycheckService employcheckService;

//    @ApiOperation(value = "分页列表")
//    @GetMapping("{page}/{limit}")
//    public R1 pageList(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit,
//
//            @ApiParam(name = "key", value = "查询", required = false)
//                    Object key
//    ){
//        System.out.println(key);
//        Page<Employcheck> pageParam = new Page<>(page, limit);
//
//        //teacherService.page(pageParam, null);
//       // employcheckService.pageQuery(pageParam,k);
//
//        List<Employcheck> records = pageParam.getRecords();
//
//        long total = pageParam.getTotal();
//        //return  R1.ok().put("total", total).data("rows", records);
//        return R1.ok().put("page", page);
//    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ApiOperation(value = "list")
    //@RequiresPermissions("hr:employcheck:list")
    public R1 list(@RequestParam Map<String, Object> params){
        PageUtils page = employcheckService.queryPage(params);
        System.out.println("list:"+page);
        return R1.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "考勤列表")
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hr:employcheck:info")
    public R1 info(@PathVariable("id") Integer id){
		Employcheck  employcheck = employcheckService.getById(id);

        return R1.ok().put("employcheck", employcheck);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增考勤记录")
    @RequestMapping("/save")
    //@RequiresPermissions("hr:employcheck:save")
    public R1 save(
            @ApiParam(name = "check",value = "考勤记录",required = true)
            @RequestBody Employcheck employcheck){
		employcheckService.save(employcheck);

        return R1.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hr:employcheck:update")
    public R1 update(@RequestBody Employcheck employcheck){
		employcheckService.updateById(employcheck);

        return R1.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hr:employcheck:delete")
    public R1 delete(@RequestBody Integer[] ids){
		employcheckService.removeByIds(Arrays.asList(ids));

        return R1.ok();
    }

}
