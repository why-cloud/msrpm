package com.msr.msrpm.rm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.rm.entity.Audition;
import com.msr.msrpm.rm.entity.Resume;
import com.msr.msrpm.rm.query.ResumeQuery;
import com.msr.msrpm.rm.service.AuditionService;
import com.msr.msrpm.rm.service.ResumeService;
import com.msr.msrpm.rm.vo.AuditionPositionVo;
import com.msr.msrpm.rm.vo.ResumePositionVo;
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
@Api(description="面试安排")
@RestController
@RequestMapping("/rm/audition")
public class AuditionController {
    @Autowired
    private AuditionService auditionService;

    @ApiOperation(value = "分页多表")
    @GetMapping("/{page}/{size}")
    public R getAuditionPosition(

            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "size", value = "每页记录数", required = true)
            @PathVariable Integer size) {

        Page<AuditionPositionVo>  pageParam= auditionService.getAuditionPosition(new Page<>(page, size));
        List<AuditionPositionVo> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "面试安排列表")
    @GetMapping("list")
    public R list(){
        List<Audition> list = auditionService.list(null);
        return R.ok().data("item", list);
    }

    @ApiOperation(value = "根据ID删除面试安排")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id){
        boolean result = auditionService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "新增面试安排")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "audition", value = "面试安排", required = true)
            @RequestBody  Audition audition){

        auditionService.save(audition);
        return R.ok();
    }
    @ApiOperation(value = "根据ID查询面试安排")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id){

        Audition audition = auditionService.getById(id);
        return R.ok().data("audition", audition);
    }

    @ApiOperation(value = "根据ID修改面试安排")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "audition", value = "面试安排", required = true)
            @RequestBody Audition audition){

        audition.setId(id);
        auditionService.updateById(audition);
        return R.ok();
    }

}

