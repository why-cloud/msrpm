package com.msr.msrpm.ei.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Engageform;
import com.msr.msrpm.ei.entity.Politicsstatus;
import com.msr.msrpm.ei.service.PoliticsstatusService;
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
@Api(description="政治面貌")
@RestController
@RequestMapping("/ei/politicsstatus")
public class PoliticsstatusController {
    @Autowired
    private PoliticsstatusService politicsstatusService;
    @ApiOperation(value = "根据ID查询政治面貌")
    @GetMapping("{id}")
    public R getPoliticById(
            @ApiParam(name = "id", value = "politicID", required = true)
            @PathVariable Integer id){

        Politicsstatus politicsstatus = politicsstatusService.getById(id);
        return R.ok().data("politic",politicsstatus);
    }

}

