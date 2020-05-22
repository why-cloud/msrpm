package com.msr.msrpm.ei.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Engageform;
import com.msr.msrpm.ei.entity.Joblevel;
import com.msr.msrpm.ei.service.JoblevelService;
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
@Api(description="职称JobLevel")
@RestController
@RequestMapping("/ei/joblevel")
public class JoblevelController {
    @Autowired
    private JoblevelService joblevelService;
    @ApiOperation(value = "根据ID查询职称")
    @GetMapping("{id}")
    public R getJobLevelById(
            @ApiParam(name = "id", value = "JoblevelID", required = true)
            @PathVariable Integer id){

        Joblevel joblevel= joblevelService.getById(id);
        return R.ok().data("joblevel", joblevel);
    }

}

