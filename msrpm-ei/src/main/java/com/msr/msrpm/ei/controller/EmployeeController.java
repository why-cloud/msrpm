package com.msr.msrpm.ei.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.R;
import com.msr.msrpm.ei.entity.*;
import com.msr.msrpm.ei.query.EmployeeQuery;
import com.msr.msrpm.ei.service.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
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
@Api(description="员工资料")
@RestController
@RequestMapping("/ei/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EngageformService engageformService;
    @Autowired
    private JoblevelService joblevelService;
    @Autowired
    private NationService nationService;
    @Autowired
    private PoliticsstatusService politicsstatusService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private TiptopdegreeService tiptopdegreeService;
    @Autowired
    private WorkstateService workstateService;


    @ApiOperation(value = "所有员工资料")
    @GetMapping("alllist")
    public R list(){
        List<Employee> list = employeeService.getAll();
        return R.ok().data("item",list);
    }
    @ApiOperation(value = "根据ID查询部门名字")
    @GetMapping("/deplist")
    public R depList(){
        List<Department> list = employeeService.getAllDep();
        return R.ok().data("department",list);
    }
    @ApiOperation(value = "批量删除")
    @PostMapping("{idList}")
    public R removeByIds(
            @ApiParam(name="id",value = "员工id",required = true)
            @RequestBody List<String> idList){
        employeeService.removeByIds(idList);
        return R.ok();
    }

    @ApiOperation(value = "根据ID删除员工")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name="id",value = "员工id",required = true)
            @PathVariable Integer id){
        employeeService.removeById(id);
        return R.ok();
    }
    @ApiOperation(value = "分页员工列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page",value = "当前页码",required = true)
            @PathVariable Long page,

            @ApiParam(name ="limit",value = "每页记录数",required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    EmployeeQuery employeeQuery){
        Page<Employee> pageParam = new Page<>(page,limit);

        //employeeService.page(pageParam,null);
        employeeService.pageQuery(pageParam, employeeQuery);
        List<Employee> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }
    @ApiOperation(value = "新增员工")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "employee", value = "员工对象", required = true)
            @RequestBody Employee employee){

        employeeService.save(employee);
        return R.ok();
    }
    @ApiOperation(value = "根据ID查询员工")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable Integer id){

        Employee employee = employeeService.getById(id);
        return R.ok().data("employee", employee);
    }
    @ApiOperation(value = "根据ID修改员工")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable Integer id,

            @ApiParam(name = "employee", value = "员工对象", required = true)
            @RequestBody Employee employee){

        employee.setId(id);
        employeeService.updateById(employee);
        return R.ok();
    }
    /*@ApiOperation(value = "前端展示员工信息")
    @GetMapping("list")
    public R getEmployee(){
        List<Employee> employees = employeeService.getEmployee();
        return R.ok().data("employees",employees);
    }*/
    @ApiOperation(value = "所有部门列表")
    @GetMapping("/deps")
    public R depsList() {
        List<Department> departments = departmentService.list(null);
        return R.ok().data("departments",departments);
    }

    @ApiOperation(value = "所有合同形式列表")
    @GetMapping("/form")
    public R formList() {
        List<Engageform> engageforms = engageformService.list(null);
        return R.ok().data("engageforms",engageforms);
    }

    @ApiOperation(value = "职称列表")
    @GetMapping("/joblevels")
    public R jobList() {
        List<Joblevel> joblevels = joblevelService.list(null);
        return R.ok().data("joblevels",joblevels);
    }
    @ApiOperation(value = "民族列表")
    @GetMapping("/nations")
    public R nationList() {
        List<Nation> nations = nationService.list(null);
        return R.ok().data("nations",nations);
    }
    @ApiOperation(value = "政治面貌列表")
    @GetMapping("politicsstatus")
    public R politicList(){
        List<Politicsstatus> politic = politicsstatusService.list(null);
        return R.ok().data("politics",politic);
    }
    @ApiOperation(value = "职位列表")
    @GetMapping("/position")
    public R positionList(){
        List<Position> positions = positionService.list(null);
        return R.ok().data("positons",positions);
    }
    @ApiOperation(value = "最高学历列表")
    @GetMapping("/topdegree")
    public R degreeList(){
        List<Tiptopdegree> degrees = tiptopdegreeService.list(null);
        return R.ok().data("degrees",degrees);
    }
    @ApiOperation(value = "在职状态列表")
    @GetMapping("/workstate")
    public R stateList(){
        List<Workstate> states = workstateService.list(null);
        return R.ok().data("states",states);
    }


}

