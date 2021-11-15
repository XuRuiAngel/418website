package com.sza.website.service;

import com.sza.website.entity.ResearchDirection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sza.website.vo.ResearchDirectionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzw
 * @since 2021-11-13
 */
public interface ResearchDirectionService extends IService<ResearchDirection> {

    boolean addOrUpdateResearchDirection(ResearchDirectionVo researchDirectionVo);

}
