package com.sza.website.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sza.website.entity.Meeting;
import com.sza.website.service.MeetingService;
import com.sza.website.vo.MeetingVo;
import com.sza.website.vo.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
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
        if (meetingVo.getId() == null) {
            return Result.ok("更新成功!!");
        } else {
            return Result.ok("添加成功!!");
        }

    }

    @GetMapping("/future")
    public Result<?> listMeetingAfterToday() {
        Date date = new Date();
        QueryWrapper<Meeting> wrapper = new QueryWrapper<>();
        wrapper.ge("time", date);
        return Result.ok(meetingService.listMaps(wrapper), "操作成功");
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteMeeting(@PathParam("id") Integer id) {
        if (meetingService.getById(id) == null) return Result.fail("该id的会议不存在");
        return Result.ok(meetingService.removeById(id), "删除成功");
    }

    @PostMapping("/notice")
    public Result<?> noticePeople(String emails, Integer meetingId) {
        JSONArray jsonArray = JSONArray.parseArray(emails);
        meetingService.email(jsonArray, meetingId);
        return Result.ok("邮件通知成功");
    }

}

