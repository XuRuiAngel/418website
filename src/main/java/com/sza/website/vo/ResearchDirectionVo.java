package com.sza.website.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName ResearchDirectionVo.java
 * @Description 研究方向前端接收类
 * @createTime 2021_11_15 11:20:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResearchDirectionVo {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 研究方向名称
     */
    private String resName;

    /**
     * 研究方向主要内容
     */
    private String resContent;

}
