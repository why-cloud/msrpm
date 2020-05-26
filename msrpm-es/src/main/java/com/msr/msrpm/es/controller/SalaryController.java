package com.msr.msrpm.es.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.es.SalaryQuery;
import com.msr.msrpm.es.entity.Empsalary;
import com.msr.msrpm.es.entity.Salary;
import com.msr.msrpm.es.service.EmpsalaryService;
import com.msr.msrpm.es.service.SalaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@RestController
@RequestMapping("/es/salary")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @ApiOperation(value = "查询所有账套")
    @GetMapping("list")
    public R list(){
       /* try {
            int a = 10/0;//出现异常,通过演示不难发现，返回的错误结构跟项目中的返回结构不一致
        } catch (MSRException e) {
            //抛出自定义异常
            throw new MSRException(20002,"自定义异常！！！");
        }*/


        List<Salary> list = salaryService.list(null);
        return R.ok().data("item",list);
    }


    @ApiOperation(value = "分页账套列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "salaryQuery", value = "查询对象", required = false)
                    SalaryQuery salaryQuery
    ){

        Page<Salary> pageParam = new Page<>(page, limit);

        //teacherService.page(pageParam, null);
        salaryService.pageQuery(pageParam,salaryQuery);

        List<Salary> records = pageParam.getRecords();

        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

    /**
     * 根据id查询账套
     */
    @ApiOperation(value = "根据ID查询账套")
    @GetMapping("salary-info/{id}")
    public R getById(
            @ApiParam(name = "id", value = "编号", required = true)
            @PathVariable Integer id){
        Salary salary = salaryService.getById(id);
        return R.ok().data("salary",salary);
    }

    @ApiOperation(value = "添加账套")
    @PostMapping("save-salary-info")
    public R saveSalaryInfo(
            @ApiParam(name = "salary",value = "账套信息",required = true)
            @RequestBody Salary salary){
        Integer Id = salaryService.saveSalaryInfo(salary);
        if (!StringUtils.isEmpty(Id)){
            return R.ok().data("Id",Id);
        }else {
            return R.error().message("保存失败");
        }
    }

    @ApiOperation(value = "更新账套信息")
    @PutMapping("update-salary-info/{id}")
    public R updateSalaryInfoById(
            @ApiParam(name = "Salary", value = "账套信息", required = true)
            @RequestBody Salary salary,

            @ApiParam(name = "id", value = "账套ID", required = true)
            @PathVariable Integer id){
        salaryService.updateSalaryInfoById(salary);
        return R.ok();
    }

    @ApiOperation(value = "根据ID删除账套")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "账套ID", required = true)
            @PathVariable Integer id){
        // boolean flag = teacherService.removeById(id);
        // return R.ok();
        boolean result = salaryService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }




}

