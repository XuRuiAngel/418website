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
 * @author sza
 * @since 2021-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会议id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会议名称
     */
    private String name;

    /**
     * 会议时间
     */
    private Date time;

    /**
     * 会议地址
     */
    private String location;

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
     * 参会人员
     */
    private String participants;


}
