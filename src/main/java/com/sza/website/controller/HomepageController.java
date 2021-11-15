package com.sza.website.controller;


import com.sza.website.enums.FilePathEnum;
import com.sza.website.enums.StatusCodeEnum;
import com.sza.website.service.HomepageService;
import com.sza.website.strategy.context.UploadStrategyContext;
import com.sza.website.vo.HomepageVo;
import com.sza.website.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  主页前端控制器
 * </p>
 *
 * @author hzw
 * @since 2021-11-13
 */
@RestController
@RequestMapping("/website/homepage")
public class HomepageController {

    @Autowired
    HomepageService homepageService;

    @Autowired
    UploadStrategyContext uploadStrategyContext;

    @GetMapping("")
    public Result<?> getHomepage() {

        return Result.ok(homepageService.list(), StatusCodeEnum.SUCCESS);

    }

    @PostMapping("")
    public Result<?> addOrUpdateHomepage(HomepageVo homepageVo) {

        return Result.ok(homepageService.addOrUpdateHomepage(homepageVo), StatusCodeEnum.ADD_SUCCESS);

    }

    /**
     * 上传主页图片
     *
     * @param file 文件
     * @return {@link Result<String>} 主页图片地址
     */
    @PostMapping("/images")
    public Result<String> saveArticleImages(MultipartFile file) {

        return Result.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.HOMEPAGE.getPath()));

    }

}

