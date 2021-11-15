package com.sza.website.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName AchievementVo.java
 * @Description 成果前端连接类
 * @createTime 2021_11_15 16:30:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AchievementVo {

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
    private Integer resDirectionId;

}
