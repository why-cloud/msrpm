package com.msr.msrpm.ei.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Engageform;
import com.msr.msrpm.ei.entity.Workstate;
import com.msr.msrpm.ei.service.WorkstateService;
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
@Api(description="在职状态")
@RestController
@RequestMapping("/ei/workstate")
public class WorkstateController {
    @Autowired
    private WorkstateService workstateService;
    @ApiOperation(value = "根据ID查询在职状态")
    @GetMapping("{id}")
    public R getStateById(
            @ApiParam(name = "id", value = "在职状态ID", required = true)
            @PathVariable Integer id){

        Workstate workstate= workstateService.getById(id);
        return R.ok().data("workstate", workstate);
    }

}

