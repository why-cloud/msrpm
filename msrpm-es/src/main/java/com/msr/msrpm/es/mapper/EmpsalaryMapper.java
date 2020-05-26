package com.msr.msrpm.es.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.es.entity.Empsalary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.msrpm.es.vo.SalarySobVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Repository
public interface EmpsalaryMapper extends BaseMapper<Empsalary> {






    List<SalarySobVo> getSalarySobVo(Page<SalarySobVo> page);

    void selectPage(Page<SalarySobVo> pageParam, QueryWrapper<SalarySobVo> queryWrapper);

    //Object getSalarySobVo(Page<SalarySobVo> page);

    // List<SalarySobVo> getemp(Page<SalarySobVo> page);

    //SalarySobVo selectSalarySobVoById(Integer id);


}
