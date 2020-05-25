package com.msr.msrpm.rm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.rm.entity.Resume;
import com.msr.msrpm.rm.mapper.ResumeMapper;
import com.msr.msrpm.rm.query.ResumeQuery;
import com.msr.msrpm.rm.service.ResumeService;
import com.msr.msrpm.rm.vo.ResumePositionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@CrossOrigin //跨域
@Api(description="简历管理")
@RestController
@RequestMapping("/rm/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @ApiOperation(value = "简历列表")
    @GetMapping("list")
    public R list(){
        List<Resume> list = resumeService.list(null);
        return R.ok().data("item", list);
    }

    @ApiOperation(value = "分页模糊查询")
    @GetMapping("{page}/{limit}")
    public R pageList(

            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "resumeQuery", value = "查询对象", required = false)
                    ResumeQuery resumeQuery){
        Page<Resume> pageParam = new Page<>(page, limit);

        resumeService.pageQuery(pageParam, resumeQuery);
        List<Resume> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

//    @ApiOperation(value = "分页多表")
//    @GetMapping("/getResumePosition/{page}/{size}")
//    public R getResumePosition(
//
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "size", value = "每页记录数", required = true)
//            @PathVariable Integer size
//            ) {
//
//        Page<ResumePositionVo>  pageParam= resumeService.getResumePosition(new Page<>(page, size));
//
//        List<ResumePositionVo> records = pageParam.getRecords();
//        long total = pageParam.getTotal();
//
//        return  R.ok().data("total", total).data("rows", records);
//
//    }


//        @ApiOperation(value = "分页多表模糊")
//    @GetMapping("/getResumePosition/{page}/{size}")
//    public R getResumePosition(
//
//
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "size", value = "每页记录数", required = true)
//            @PathVariable Integer size
//            ) {
//            Page<Resume> pageParam = new Page<>(page, size);
//
//            QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
//
//            queryWrapper.like("r.rname", "陈");//模糊查询条件
//
//            IPage<Resume> iPage = resumeMapper.selectPage(pageParam, queryWrapper);//分页查询方法
//
//            List<Resume> records = iPage.getRecords();//获取结果
//            long total = pageParam.getTotal();
//            return  R.ok().data("total", total).data("rows", records);
//
//
//   }





    @ApiOperation(value = "根据ID删除个人简历")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id){
        boolean result = resumeService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "新增简历")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "resume", value = "简历", required = true)
            @RequestBody Resume resume){

        resumeService.save(resume);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询简历")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id){

        Resume resume = resumeService.getById(id);
        return R.ok().data("resume", resume);
    }

    @ApiOperation(value = "根据ID修改简历")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "resume", value = "简历", required = true)
            @RequestBody Resume resume){

        resume.setId(id);
        resumeService.updateById(resume);
        return R.ok();
    }
}

