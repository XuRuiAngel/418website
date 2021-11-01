package com.sza.website.service.impl;

import com.sza.website.entity.Meeting;
import com.sza.website.mapper.MeetingMapper;
import com.sza.website.service.MeetingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.MeetingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sza
 * @since 2021-10-31
 */
@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, Meeting> implements MeetingService {

    @Autowired
    MeetingService meetingService;

    @Override
    public void addOrUpdateMeeting(MeetingVo meetingVo) throws ParseException {
        Meeting meeting = BeanCopyUtils.copyObject(meetingVo, Meeting.class);
        meeting.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(meetingVo.getTime()));
        meeting.setDeleted(0);
        meetingService.saveOrUpdate(meeting);
    }
}
