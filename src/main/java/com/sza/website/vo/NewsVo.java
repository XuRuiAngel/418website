package com.sza.website.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName NewsVo.java
 * @Description 新闻前端连接类
 * @createTime 2021_11_06 17:38:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewsVo {

    /**
     * 新闻id
     */
    private Integer id;

    /**
     * 标题
     */
    @NotBlank(message = "新闻标题不能为空")
    private String title;

    /**
     * 作者
     */
    @NotBlank(message = "新闻作者不能为空")
    private String author;

    /**
     * 发布者
     */
    private String publisher;

    /**
     * 图片
     */
    private String image;

    /**
     * 课题组id
     */
    @NotBlank(message = "新闻所属课题组id不能为空")
    private Integer groupId;

    /**
     * 新闻类型
     */
    @NotBlank(message = "新闻类型不能为空")
    private String newsType;

}
