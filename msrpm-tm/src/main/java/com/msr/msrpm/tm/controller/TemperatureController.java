package com.msr.msrpm.tm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.tm.entity.Temperature;
import com.msr.msrpm.tm.service.TemperatureService;
import com.msr.msrpm.tm.vo.TemperatureVo;
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
@Api(description="体温管理")
@RestController
@RequestMapping("/tm/temperature")
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;
    @ApiOperation(value = "体温列表")
    @GetMapping("list")
    public R list(){
        List<Temperature> list = temperatureService.list(null);
        return R.ok().data("item", list);
    }

//    @ApiOperation(value = "分页体温管理")
//    @GetMapping("{page}/{limit}")
//    public R
//    pageList(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit){
//
//        Page<Temperature> pageParam = new Page<>(page, limit);
//
//        temperatureService.page(pageParam, null);
//        List<Temperature> records = pageParam.getRecords();
//
//        long total = pageParam.getTotal();
//        return  R.ok().data("total", total).data("rows", records);
//    }

    @ApiOperation(value = "分页多表")
    @GetMapping("/{page}/{size}")
    public R pageList(

            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "size", value = "每页记录数", required = true)
            @PathVariable Integer size) {

        Page<TemperatureVo>  pageParam= temperatureService.getTemperature(new Page<>(page, size));
        List<TemperatureVo> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增体温")
    @PostMapping
    public R save(
            @ApiParam(name = "temperature", value = "体温对象", required = true)
            @RequestBody Temperature temperature){

        temperatureService.save(temperature);
        return R.ok();
    }

    @ApiOperation(value = "根据ID删除体温")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable Integer id){
        boolean result = temperatureService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "根据ID查询体温")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable Integer id){

            Temperature temperature = temperatureService.getById(id);
            return R.ok().data("temperature", temperature);
    }

    @ApiOperation(value = "根据ID修改体温")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable Integer id,

            @ApiParam(name = "temperature", value = "员工体温", required = true)
            @RequestBody Temperature temperature){

            temperature.setId(id);
            temperatureService.updateById(temperature);
            return R.ok();
    }

}

