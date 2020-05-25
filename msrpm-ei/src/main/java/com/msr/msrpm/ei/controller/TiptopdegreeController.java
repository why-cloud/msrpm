package com.msr.msrpm.ei.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Engageform;
import com.msr.msrpm.ei.entity.Tiptopdegree;
import com.msr.msrpm.ei.service.TiptopdegreeService;
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
@Api(description="最高学历")
@RestController
@RequestMapping("/ei/tiptopdegree")
public class TiptopdegreeController {
    @Autowired
    private TiptopdegreeService tiptopdegreeService;
    @ApiOperation(value = "根据ID查询最高学历")
    @GetMapping("{id}")
    public R getDegreeById(
            @ApiParam(name = "id", value = "学历ID", required = true)
            @PathVariable Integer id){

        Tiptopdegree topdegree = tiptopdegreeService.getById(id);
        return R.ok().data("topdegree", topdegree);
    }

}

