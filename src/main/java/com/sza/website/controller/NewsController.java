package com.sza.website.controller;


import com.sza.website.entity.News;
import com.sza.website.enums.FilePathEnum;
import com.sza.website.enums.StatusCodeEnum;
import com.sza.website.service.NewsService;
import com.sza.website.strategy.context.UploadStrategyContext;
import com.sza.website.vo.NewsVo;
import com.sza.website.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * <p>
 *  新闻前端控制器
 * </p>
 *
 * @author hzw
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/website/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    /**
     * 得到所有新闻信息
     *
     * @return
     */
    @GetMapping("")
    public Result<?> listNews() {

        return Result.ok(newsService.listMaps(), StatusCodeEnum.SUCCESS.getMsg());

    }

    /**
     * 添加或修改新闻信息
     *
     * @param newsVo
     * @return
     * @throws ParseException
     */
    @PostMapping("")
    public Result<?> addOrUpdateNews(@Valid NewsVo newsVo) {

        if(newsVo.getId() == null) {
            return Result.ok(newsService.addOrUpdateNews(newsVo), StatusCodeEnum.ADD_SUCCESS);
        } else {
            if(newsService.getById(newsVo.getId()) == null) {
                return Result.fail(StatusCodeEnum.UPDATE_FAIL);
            } else {
                return Result.ok(newsService.addOrUpdateNews(newsVo), StatusCodeEnum.UPDATE_SUCCESS);
            }
        }

    }

    /**
     * 根据ID删除新闻信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteNews(@PathVariable("id") Integer id) {

        if(newsService.getById(id) == null) return Result.fail(StatusCodeEnum.DELETE_FAIL);
        return Result.ok(newsService.removeById(id), StatusCodeEnum.DELETE_SUCCESS);

    }

    /**
     * 批量删除新闻
     *
     * @param idList
     * @return
     */
    @DeleteMapping("")
    public Result<?> deleteNews(List<Integer> idList) {

        if(idList.size() == 0) {
            return Result.fail(StatusCodeEnum.DELETE_FAIL);
        } else {
            return Result.ok(newsService.removeByIds(idList), StatusCodeEnum.DELETE_SUCCESS);
        }

    }

    /**
     * 上传新闻图片
     *
     * @param file 文件
     * @return {@link Result<String>} 新闻图片地址
     */
    @PostMapping("/images")
    public Result<String> saveArticleImages(MultipartFile file) {

        return Result.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.NEWS.getPath()));

    }

    /**
     * 根据ID查看指定新闻信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<?> getNewById(@PathVariable("id") Integer id) {

        News news = newsService.getById(id);
        if(news == null) return Result.fail(StatusCodeEnum.SEARCH_FAIL);
        return Result.ok(news, StatusCodeEnum.SEARCH_SUCCESS);

    }

}

