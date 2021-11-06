package com.sza.website.service;

import com.alibaba.fastjson.JSONArray;
import com.sza.website.entity.Meeting;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sza.website.vo.MeetingVo;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sza
 * @since 2021-10-31
 */
public interface MeetingService extends IService<Meeting> {

    void addOrUpdateMeeting(MeetingVo meetingVo) throws ParseException;

    void email(JSONArray emails, Integer meetingId);

}
