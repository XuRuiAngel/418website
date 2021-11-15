package com.sza.website.service;

import com.sza.website.entity.Homepage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sza.website.vo.HomepageVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzw
 * @since 2021-11-13
 */
public interface HomepageService extends IService<Homepage> {

    /**
     * 增加或者删除homepagess
     * @param homepageVo
     * @return
     */
    boolean addOrUpdateHomepage(HomepageVo homepageVo);

}
