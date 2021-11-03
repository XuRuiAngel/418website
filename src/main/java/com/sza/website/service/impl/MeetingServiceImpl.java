package com.sza.website.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sza.website.dto.EmailDTO;
import com.sza.website.entity.Meeting;
import com.sza.website.exception.MyException;
import com.sza.website.mapper.MeetingMapper;
import com.sza.website.service.MeetingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.MeetingVo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.sza.website.constant.MQPrefixConst.*;

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
    MeetingMapper meetingMapper;

    @Autowired
    MeetingService meetingService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void addOrUpdateMeeting(MeetingVo meetingVo) throws ParseException {
        Meeting meeting = BeanCopyUtils.copyObject(meetingVo, Meeting.class);
        meeting.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(meetingVo.getTime()));
        meeting.setDeleted(0);
        meetingService.saveOrUpdate(meeting);
    }

    @Override
    public void email(JSONArray emails, Integer meetingId) {
        Meeting meeting = meetingMapper.selectById(meetingId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (meetingId == null) throw new MyException("该id的会议不存在!");
        String content = "您好!您有新的会议通知!!!\n"
                        + "会议名称:" + meeting.getName() + "\n"
                        + "会议时间:" + simpleDateFormat.format(meeting.getTime()) + "\n"
                        + "会议地点:" + meeting.getLocation() + "\n"
                        + "参会人员:" + meeting.getParticipants() + "\n";
        for (int i = 0; i < emails.size(); i++) {
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setContent(content);
            emailDTO.setSubject("会议通知");
            emailDTO.setEmail(emails.getJSONObject(i).getString("email"));
            rabbitTemplate.convertAndSend(NOTICE_EXCHANGE, NOTICE_EMAIL_ROUTINGKEY, new Message(JSON.toJSONBytes(emailDTO), new MessageProperties()));
        }

    }
}
