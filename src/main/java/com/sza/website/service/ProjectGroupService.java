package com.sza.website.service;

import com.sza.website.entity.ProjectGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sza.website.vo.GroupVo;

import java.text.ParseException;

/**
 * <p>
 *  课题组服务类
 * </p>
 *
 * @author hzw
 * @since 2021-11-06
 */
public interface ProjectGroupService extends IService<ProjectGroup> {

    boolean addOrUpdateGroup(GroupVo groupVo);

}
