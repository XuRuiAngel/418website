package com.sza.website.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName FilePathEnum.java
 * @Description 文件路径枚举类
 * @createTime 2021_11_08 17:38:00
 */
@Getter
@AllArgsConstructor
public enum FilePathEnum {

    /**
     * 头像路径
     */
    AVATAR("avatar/", "头像路径"),

    /**
     * 新闻路径
     */
    NEWS("news/", "新闻路径"),

    /**
     * 主页路径
     */
    HOMEPAGE("homepage/", "主页路径");

    /**
     * 路径
     */
    private final String path;

    /**
     * 描述
     */
    private final String description;

}
