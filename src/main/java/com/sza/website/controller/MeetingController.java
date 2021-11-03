package com.sza.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sza.website.entity.Meeting;
import com.sza.website.service.MeetingService;
import com.sza.website.vo.MeetingVo;
import com.sza.website.vo.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sza
 * @since 2021-10-31
 */
@RestController
@RequestMapping("/website/meeting")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("")
    public Result<?> listMeeting() {
        return Result.ok(meetingService.listMaps(), "操作成功");
    }

    @PostMapping("")
    public Result<?> addOrUpdateMeeting(@Valid  MeetingVo meetingVo) throws ParseException {
        meetingService.addOrUpdateMeeting(meetingVo);
        return Result.ok();
    }

    @GetMapping("/future")
    public Result<?> listMeetingAfterToday() {
        Date date = new Date();
        QueryWrapper<Meeting> wrapper = new QueryWrapper<>();
        wrapper.ge("time", date);
        return Result.ok(meetingService.listMaps(wrapper), "操作成功");
    }

    @DeleteMapping("")
    public Result<?> deleteMeeting(Integer id) {
        if (id == null) return Result.fail("id不能为空");
        if (meetingService.getById(id) == null) return Result.fail("该id的会议不存在");
        return Result.ok(meetingService.removeById(id), "删除成功");
    }

    @GetMapping("/notice")
    public Result<?> noticePeople(List<String> emails, Integer id) {
        return null;
    }



}

