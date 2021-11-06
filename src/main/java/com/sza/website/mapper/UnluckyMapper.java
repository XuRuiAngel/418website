package com.sza.website.mapper;

import com.sza.website.entity.Unlucky;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sza
 * @since 2021-11-04
 */
@Mapper
@Repository
public interface UnluckyMapper extends BaseMapper<Unlucky> {

}
