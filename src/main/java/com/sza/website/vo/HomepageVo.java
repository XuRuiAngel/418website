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
 * @ClassName HomepageVo.java
 * @Description 主页前端连接类
 * @createTime 2021_11_13 11:17:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HomepageVo {

    /**
     * 主页id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 展示图片
     */
    private String image;

}
