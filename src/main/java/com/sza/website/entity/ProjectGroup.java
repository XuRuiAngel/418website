package com.sza.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzw
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课题组id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课题组名称
     */
    private String groupName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 上次修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer deleted;

    /**
     * 课题组简介
     */
    private String description;


}
