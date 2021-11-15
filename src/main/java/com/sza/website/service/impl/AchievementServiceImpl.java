package com.sza.website.service.impl;

import com.sza.website.entity.Achievement;
import com.sza.website.mapper.AchievementMapper;
import com.sza.website.service.AchievementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.AchievementVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  成果服务实现类
 * </p>
 *
 * @author hzw
 * @since 2021-11-15
 */
@Service
public class AchievementServiceImpl extends ServiceImpl<AchievementMapper, Achievement> implements AchievementService {

    @Override
    public boolean addOrUpdateAchievement(AchievementVo achievementVo) {

        Achievement achievement = BeanCopyUtils.copyObject(achievementVo, Achievement.class);
        achievement.setDeleted(0);
        return this.saveOrUpdate(achievement);

    }

}
