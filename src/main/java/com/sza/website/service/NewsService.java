package com.sza.website.service;

import com.sza.website.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sza.website.vo.NewsVo;

import java.text.ParseException;

/**
 * <p>
 *  新闻服务类
 * </p>
 *
 * @author hzw
 * @since 2021-11-06
 */
public interface NewsService extends IService<News> {

    /**
     * 增加或者删除新闻
     * @param newsVo 新闻前端接收类
     * @return
     */
    boolean addOrUpdateNews(NewsVo newsVo);

}
