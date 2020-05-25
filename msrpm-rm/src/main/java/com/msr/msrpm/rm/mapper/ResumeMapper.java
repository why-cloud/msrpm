package com.msr.msrpm.rm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.msrpm.rm.entity.Resume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.msrpm.rm.query.ResumeQuery;
import com.msr.msrpm.rm.vo.ResumePositionVo;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;
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
public interface ResumeMapper extends BaseMapper<Resume> {

   //@Select("SELECT resume.*,position.`name` FROM resume,position WHERE resume.appli_posId=position.id")

   //List<ResumePositionVo> getResumePosition(Page<ResumePositionVo> page);
}
