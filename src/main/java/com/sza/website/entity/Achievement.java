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
 *  成果实体类
 * </p>
 *
 * @author hzw
 * @since 2021-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 研究成果id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 成果名称
     */
    private String achName;

    /**
     * 获得成果时间
     */
    private Date achTime;

    /**
     * 成果内容
     */
    private String achContent;

    /**
     * 所属课题组
     */
    private Integer groupId;

    /**
     * 所属研究方向
     */
    @TableField("resDirection_id")
    private Integer resDirectionId;

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

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer deleted;


}
