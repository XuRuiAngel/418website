package com.sza.website.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName UploadStrategy.java
 * @Description 上传策略
 * @createTime 2021_11_08 18:16:00
 */
public interface UploadStrategy {

    /**
     * 上传文件
     *
     * @param file 文件
     * @param path 上传路径
     * @return 文件地址
     */
    String uploadFile(MultipartFile file, String path);

}
