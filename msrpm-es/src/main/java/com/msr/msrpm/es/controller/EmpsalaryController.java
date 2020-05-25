package com.msr.msrpm.es.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.es.EmpsalaryQuery;
import com.msr.msrpm.es.entity.Empsalary;

import com.msr.msrpm.es.entity.Salary;
import com.msr.msrpm.es.vo.SalarySobVo;
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
 * @since 2020-05-18
 */
@CrossOrigin //跨域
@RestController
@RequestMapping("/es/empsalary")
public class EmpsalaryController {
    @Autowired
    private EmpsalaryService empsalaryService;

    @ApiOperation(value = "所有信息")
    @GetMapping("/")
    public R list(){
       /* try {
            int a = 10/0;//出现异常,通过演示不难发现，返回的错误结构跟项目中的返回结构不一致
        } catch (MSRException e) {
            //抛出自定义异常
            throw new MSRException(20002,"自定义异常！！！");
        }*/


        List<Empsalary> list = empsalaryService.list(null);
        return R.ok().data("item",list);
    }

//    @ApiOperation(value = "分页查询")
//    @GetMapping("{page}/{limit}")
//    public R pageList(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit,
//
//            @ApiParam(name = "empsalaryQuery", value = "查询对象", required = false)
//                   EmpsalaryQuery empsalaryQuery
//
//    ){
//
//       Page<Empsalary> pageParam = new Page<>(page, limit);
//       // Page<Empsalary> pageParam = empsalaryService.getEmp(new Page<>(page, limit));
//
//       empsalaryService.pageQuery(pageParam,empsalaryQuery);
//
//        List<Empsalary> records = pageParam.getRecords();
//
//        long total = pageParam.getTotal();
//        return  R.ok().data("total", total).data("rows", records);
//    }





    @ApiOperation(value = "多表分页查询")
    @GetMapping("{page}/{limit}")
    public R getSalarySobVo(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit

            //@ApiParam(name = "empsalaryQuery", value = "查询对象", required = false)
                 //   EmpsalaryQuery empsalaryQuery

    ){

       // Page<Empsalary> pageParam = new Page<>(page, limit);
        Page<SalarySobVo> pageParam = empsalaryService.getSalarySobVo(new Page<>(page, limit));

        //empsalaryService.pageQuery(pageParam,empsalaryQuery);

        List<SalarySobVo> records = pageParam.getRecords();

        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }


    @ApiOperation(value = "更新员工账套")
    @PutMapping("update-empsalary-info/{id}")
    public R updateEmpsalaryInfoById(
            @ApiParam(name = "Empsalary", value = "账套信息", required = true)
            @RequestBody Empsalary empsalary,

            @ApiParam(name = "id", value = "empID", required = true)
            @PathVariable Integer id){
        empsalaryService.updateEmpsalaryInfoById(empsalary);
        return R.ok();
    }
    @ApiOperation(value = "根据ID查询账套")
    @GetMapping("empsalary-info/{id}")
    public R getById(
            @ApiParam(name = "id", value = "empID", required = true)
            @PathVariable Integer id){
        Empsalary empsalary = empsalaryService.getById(id);
        return R.ok().data("empsalary",empsalary);
    }








}

