package com.sza.website.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sza.website.entity.ResearchDirection;
import com.sza.website.mapper.ResearchDirectionMapper;
import com.sza.website.service.ResearchDirectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.ResearchDirectionVo;
import org.springframework.beans.BeanUtils;
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
public class ResearchDirectionServiceImpl extends ServiceImpl<ResearchDirectionMapper, ResearchDirection> implements ResearchDirectionService {

    @Override
    public boolean addOrUpdateResearchDirection(ResearchDirectionVo researchDirectionVo) {

        ResearchDirection researchDirection = BeanCopyUtils.copyObject(researchDirectionVo, ResearchDirection.class);
        researchDirection.setDeleted(0);
        return this.saveOrUpdate(researchDirection);

    }
}
