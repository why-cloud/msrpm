package com.msr.msrpm.ei.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Engageform;
import com.msr.msrpm.ei.service.EngageformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@CrossOrigin //跨域
@Api(description="聘用形式")
@RestController
@RequestMapping("/ei/engageform")
public class EngageformController {
    @Autowired
    private EngageformService engageformService;
    @ApiOperation(value = "根据ID查询聘用形式")
    @GetMapping("{id}")
    public R getFormById(
            @ApiParam(name = "id", value = "formID", required = true)
            @PathVariable Integer id){

        Engageform form= engageformService.getById(id);
        return R.ok().data("form", form);
    }

}

