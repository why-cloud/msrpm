package com.msr.msrpm.ei.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Engageform;
import com.msr.msrpm.ei.entity.Nation;
import com.msr.msrpm.ei.service.NationService;
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
@Api(description="民族")
@RestController
@RequestMapping("/ei/nation")
public class NationController {
    @Autowired
    private NationService nationService;
    @ApiOperation(value = "根据ID查询民族名字")
    @GetMapping("{id}")
    public R getNationById(
            @ApiParam(name = "id", value = "民族ID", required = true)
            @PathVariable Integer id){

        Nation nation= nationService.getById(id);
        return R.ok().data("nation", nation);
    }

}

