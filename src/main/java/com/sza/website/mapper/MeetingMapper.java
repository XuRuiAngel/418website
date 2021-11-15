package com.sza.website.mapper;

import com.sza.website.entity.Meeting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  会议 Mapper 接口
 * </p>
 *
 * @author sza
 * @since 2021-10-31
 */
@Mapper
@Repository
public interface MeetingMapper extends BaseMapper<Meeting> {

}
