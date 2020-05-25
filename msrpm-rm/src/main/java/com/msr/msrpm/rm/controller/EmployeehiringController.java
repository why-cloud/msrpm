package com.msr.msrpm.rm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.rm.entity.Audition;
import com.msr.msrpm.rm.entity.Employeehiring;
import com.msr.msrpm.rm.service.EmployeehiringService;
import com.msr.msrpm.rm.vo.AuditionPositionVo;
import com.msr.msrpm.rm.vo.EmployeehiringVo;
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
@Api(description="录用人员")
@RestController
@RequestMapping("/rm/employeehiring")
public class EmployeehiringController {
    @Autowired
    EmployeehiringService employeehiringService;
    @ApiOperation(value = "分页多表")
    @GetMapping("/{page}/{size}/{employeehiringVo}")
    public R getAuditionPosition(

            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "size", value = "每页记录数", required = true)
            @PathVariable Integer size,

            @PathVariable EmployeehiringVo employeehiringVo
    ) {

        Page<EmployeehiringVo>  pageParam= employeehiringService.getEmployeeHiring(new Page<>(page, size),employeehiringVo);
        List<EmployeehiringVo> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "录用人员列表")
    @GetMapping("list")
    public R list(){
        List<Employeehiring> list = employeehiringService.list(null);
        return R.ok().data("item", list);
    }

    @ApiOperation(value = "根据ID删除录用人员")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id){
        boolean result = employeehiringService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "新增录用人员")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "employeehiring", value = "面试安排", required = true)
            @RequestBody  Employeehiring employeehiring){

        employeehiringService.save(employeehiring);
        return R.ok();
    }
    @ApiOperation(value = "根据ID查询录用人员")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id){

        Employeehiring employeehiring = employeehiringService.getById(id);
        return R.ok().data("audition", employeehiring);
    }

    @ApiOperation(value = "根据ID修改录用人员")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "employeehiring", value = "面试安排", required = true)
            @RequestBody Employeehiring employeehiring){

        employeehiring.setId(id);
        employeehiringService.updateById(employeehiring);
        return R.ok();
    }

}

