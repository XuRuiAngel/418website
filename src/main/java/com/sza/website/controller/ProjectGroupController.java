package com.sza.website.controller;


import com.sza.website.entity.ProjectGroup;
import com.sza.website.enums.StatusCodeEnum;
import com.sza.website.service.ProjectGroupService;
import com.sza.website.vo.GroupVo;
import com.sza.website.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

/**
 * <p>
 *  课题组前端控制器
 * </p>
 *
 * @author hzw
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/website/project-group")
public class ProjectGroupController {

    @Autowired
    ProjectGroupService projectGroupService;

    /**
     * 得到所有课题组信息
     *
     * @return
     */
    @GetMapping("")
    public Result<?> listGroups() {

        return Result.ok(projectGroupService.listMaps(), StatusCodeEnum.SUCCESS);

    }

    /**
     * 添加或修改课题组信息
     *
     * @param groupVo
     * @return
     * @throws ParseException
     */
    @PostMapping("")
    public Result<?> addOrUpdateGroup(@Valid GroupVo groupVo) {

        if(groupVo.getId() == null) {
            return Result.ok(projectGroupService.addOrUpdateGroup(groupVo), StatusCodeEnum.ADD_SUCCESS);
        } else {
            if(projectGroupService.getById(groupVo.getId()) == null) {
                return Result.fail(StatusCodeEnum.UPDATE_FAIL);
            } else {
                return Result.ok(projectGroupService.addOrUpdateGroup(groupVo), StatusCodeEnum.UPDATE_SUCCESS);
            }
        }

    }

    /**
     * 删除课题组
     *
     * @param id
     * @return
     */
    @DeleteMapping("")
    public Result<?> deleteGroup(Integer id) {

        if(id == null) return Result.fail(StatusCodeEnum.DELETE_FAIL);
        if(projectGroupService.getById(id) == null) return Result.fail(StatusCodeEnum.DELETE_FAIL);
        return Result.ok(projectGroupService.removeById(id), StatusCodeEnum.DELETE_SUCCESS.getMsg());

    }

    /**
     * 根据ID查看指定课题组信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<?> getGroupById(@PathVariable("id") Integer id) {

        if(id == null) return Result.fail(StatusCodeEnum.SEARCH_FAIL);
        ProjectGroup projectGroup = projectGroupService.getById(id);
        if(projectGroup == null) return Result.fail(StatusCodeEnum.SEARCH_FAIL);
        return Result.ok(projectGroup, StatusCodeEnum.SEARCH_SUCCESS);

    }

}

