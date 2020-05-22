package com.msr.msrpm.ei.controller;


import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.Engageform;
import com.msr.msrpm.ei.entity.Position;
import com.msr.msrpm.ei.service.PositionService;
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
@Api(description="职位Position")
@RestController
@RequestMapping("/ei/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @ApiOperation(value = "根据ID查询职位")
    @GetMapping("{id}")
    public R getPositionById(
            @ApiParam(name = "id", value = "posID", required = true)
            @PathVariable Integer id){

        Position position = positionService.getById(id);
        return R.ok().data("position",position);
    }

}

