package com.sza.website.service.impl;

import com.sza.website.entity.Homepage;
import com.sza.website.mapper.HomepageMapper;
import com.sza.website.service.HomepageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.HomepageVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzw
 * @since 2021-11-13
 */
@Service
public class HomepageServiceImpl extends ServiceImpl<HomepageMapper, Homepage> implements HomepageService {

    @Override
    public boolean addOrUpdateHomepage(HomepageVo homepageVo) {

        Homepage homepage = BeanCopyUtils.copyObject(homepageVo, Homepage.class);
        return this.saveOrUpdate(homepage);

    }
}
