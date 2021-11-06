package com.sza.website.service.impl;

import com.sza.website.entity.ProjectGroup;
import com.sza.website.mapper.ProjectGroupMapper;
import com.sza.website.service.ProjectGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * <p>
 *  课题组服务实现类
 * </p>
 *
 * @author hzw
 * @since 2021-11-06
 */
@Service
public class ProjectGroupServiceImpl extends ServiceImpl<ProjectGroupMapper, ProjectGroup> implements ProjectGroupService {

    @Autowired
    ProjectGroupService projectGroupService;

    @Override
    public boolean addOrUpdateGroup(GroupVo groupVo) {

        ProjectGroup projectGroup= BeanCopyUtils.copyObject(groupVo, ProjectGroup.class);
        projectGroup.setDeleted(0);
        return projectGroupService.saveOrUpdate(projectGroup);

    }
}
