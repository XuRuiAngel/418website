package com.sza.website.controller;


import com.sza.website.entity.Achievement;
import com.sza.website.enums.StatusCodeEnum;
import com.sza.website.service.AchievementService;
import com.sza.website.vo.AchievementVo;
import com.sza.website.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzw
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/website/achievement")
public class AchievementController {

    @Autowired
    AchievementService achievementService;

    /**
     * 列出所有成果
     *
     * @return
     */
    @GetMapping("")
    public Result<?> listAllAchievement() {

        return Result.ok(achievementService.listMaps(), StatusCodeEnum.SUCCESS);

    }

    /**
     * 新增或更新成果信息
     *
     * @param achievementVo
     * @return
     */
    @PostMapping("")
    public Result<?> addOrUpdateAchievement(@Valid AchievementVo achievementVo) {

        if(achievementVo.getId() == null) {
            return Result.ok(achievementService.addOrUpdateAchievement(achievementVo), StatusCodeEnum.ADD_SUCCESS);
        } else {
            if(achievementService.getById(achievementVo.getId()) == null) {
                return Result.fail(StatusCodeEnum.UPDATE_FAIL);
            } else {
                return Result.ok(achievementService.addOrUpdateAchievement(achievementVo), StatusCodeEnum.UPDATE_SUCCESS);
            }
        }

    }

    /**
     * 批量删除成果
     *
     * @param idList
     * @return
     */
    @DeleteMapping("")
    public Result<?> deleteAchievement(List<Integer> idList) {

        if(idList.size() == 0) {
            return Result.fail(StatusCodeEnum.DELETE_FAIL);
        } else {
            return Result.ok(achievementService.removeByIds(idList), StatusCodeEnum.DELETE_SUCCESS);
        }

    }

    /**
     * 根据Id删除成果
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteAchievementById(@PathVariable Integer id) {

        if(achievementService.getById(id) == null) {
            return Result.fail(StatusCodeEnum.DELETE_FAIL);
        } else {
            return Result.ok(achievementService.removeById(id), StatusCodeEnum.DELETE_SUCCESS);
        }

    }

    /**
     * 根据id查找成果信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<?> getAchievementById(@PathVariable Integer id) {

        Achievement achievement = achievementService.getById(id);
        if( achievement== null) {
            return Result.fail(StatusCodeEnum.SEARCH_FAIL);
        } else {
            return Result.ok(achievement, StatusCodeEnum.SEARCH_SUCCESS);
        }

    }

}

