package com.msr.msrpm.es.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Empsalary对象", description="")
public class Empsalary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    //@TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "")
   // @TableName(value = "resume AS r LEFT JOIN position AS p ON r.appli_posId = p.id")
    private Integer eid;

    @ApiModelProperty(value = "")
   // @TableName(value = "resume AS r LEFT JOIN position AS p ON r.appli_posId = p.id")
    private Integer sid;
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getEid() {
//        return eid;
//    }
//
//    public void setEid(Integer eid) {
//        this.eid = eid;
//    }
//
//    public Integer getSid() {
//        return sid;
//    }
//
//    public void setSid(Integer sid) {
//        this.sid = sid;
//    }

}
