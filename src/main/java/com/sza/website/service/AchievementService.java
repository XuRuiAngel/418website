package com.sza.website.service;

import com.sza.website.entity.Achievement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sza.website.vo.AchievementVo;

/**
 * <p>
 *  成果服务类
 * </p>
 *
 * @author hzw
 * @since 2021-11-15
 */
public interface AchievementService extends IService<Achievement> {

    boolean addOrUpdateAchievement(AchievementVo achievementVo);

}
