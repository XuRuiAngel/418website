package com.sza.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * @since 2021-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Homepage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主页id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 展示图片
     */
    private String image;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
