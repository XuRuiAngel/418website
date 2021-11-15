package com.sza.website.service.impl;

import com.sza.website.entity.News;
import com.sza.website.mapper.NewsMapper;
import com.sza.website.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.NewsVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  新闻服务实现类
 * </p>
 *
 * @author hzw
 * @since 2021-11-06
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Override
    public boolean addOrUpdateNews(NewsVo newsVo) {

        News news = BeanCopyUtils.copyObject(newsVo, News.class);
        news.setDeleted(0);
        return this.saveOrUpdate(news);

    }

}
