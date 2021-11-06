package com.sza.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sza.website.entity.Meeting;
import com.sza.website.entity.Unlucky;
import com.sza.website.service.UnluckyService;
import com.sza.website.vo.Result;
import com.sza.website.vo.UnluckyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sza
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/website/unlucky")
public class UnluckyController {

    @Autowired
    UnluckyService unluckyService;

    @GetMapping("")
    public Result<?> listAll() {
        return Result.ok(unluckyService.listMaps(), "查询成功");
    }

    @PostMapping("")
    public Result<?> addOrUpdateUnlucky(@Valid UnluckyVo unluckyVo) throws ParseException {
        unluckyService.addOrUpdateUnlucky(unluckyVo);
        if (unluckyVo.getId() == null) {
            return Result.ok("添加成功!");
        } else {
            return Result.ok("更新成功!");
        }
    }

    @GetMapping("/week")
    public Result<?> getWeekUnlucky() {
        Date date = new Date();
        QueryWrapper<Unlucky> wrapper = new QueryWrapper<>();
        wrapper.between("time", date, new Date(date.getTime() + (long)7*24*60*60*1000));
        return Result.ok(unluckyService.listMaps(wrapper), "ok");
    }

    @DeleteMapping("")
    public Result<?> deleteUnlucky(Integer id) {
        if (id == null) return Result.fail("id不能为空");
        if (unluckyService.getById(id) == null) return Result.fail("该id的值日记录不存在!");
        unluckyService.removeById(id);
        return Result.ok("删除成功!");
    }



}

