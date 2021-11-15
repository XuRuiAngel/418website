package com.sza.website.controller;


import com.sza.website.entity.ResearchDirection;
import com.sza.website.enums.StatusCodeEnum;
import com.sza.website.service.ResearchDirectionService;
import com.sza.website.vo.ResearchDirectionVo;
import com.sza.website.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  研究方向前端控制器
 * </p>
 *
 * @author hzw
 * @since 2021-11-13
 */
@RestController
@RequestMapping("/website/research-direction")
public class ResearchDirectionController {

    @Autowired
    ResearchDirectionService researchDirectionService;

    /**
     * 得到所有研究方向信息
     *
     * @return
     */
    @GetMapping("")
    public Result<?> getAllResearchDirection() {

        return Result.ok(researchDirectionService.listMaps(), StatusCodeEnum.SUCCESS);

    }

    /**
     * 添加或更新研究方向
     *
     * @param researchDirectionVo
     * @return
     */
    @PostMapping("")
    public Result<?> addOrUpdateResearchDirection(ResearchDirectionVo researchDirectionVo) {

        if(researchDirectionVo.getId() == null) {
            return Result.ok(researchDirectionService.addOrUpdateResearchDirection(researchDirectionVo), StatusCodeEnum.ADD_SUCCESS);
        } else {
            if(researchDirectionService.getById(researchDirectionVo.getId()) == null) {
                return Result.fail(StatusCodeEnum.UPDATE_FAIL);
            } else {
                return Result.ok(researchDirectionService.addOrUpdateResearchDirection(researchDirectionVo), StatusCodeEnum.UPDATE_SUCCESS);
            }
        }

    }

    /**
     * 根据id批量删除研究方向
     *
     * @param idList
     * @return
     */
    @DeleteMapping("")
    public Result<?> deleteResearchDirection(List<Integer> idList) {

        if(idList.size() == 0) {
            return Result.fail(StatusCodeEnum.DELETE_FAIL);
        } else {
            return Result.ok(researchDirectionService.removeByIds(idList), StatusCodeEnum.DELETE_SUCCESS);
        }

    }

    /**
     * 根据id删除指定研究方向
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteResearchDirectionById(@PathVariable("id") Integer id) {

        if(researchDirectionService.getById(id) == null) {
            return Result.fail(StatusCodeEnum.DELETE_FAIL);
        } else {
            return Result.ok(researchDirectionService.removeById(id), StatusCodeEnum.DELETE_SUCCESS);
        }

    }

    /**
     * 根据id查找指定研究方向
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<?> getResearchDirectionById(@PathVariable("id") Integer id) {

        ResearchDirection researchDirection = researchDirectionService.getById(id);
        if(researchDirection==null) return Result.fail(StatusCodeEnum.SEARCH_FAIL);
        return Result.ok(researchDirection, StatusCodeEnum.SEARCH_SUCCESS);

    }

}

