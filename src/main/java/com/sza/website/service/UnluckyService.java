package com.sza.website.service;

import com.sza.website.entity.Unlucky;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sza.website.vo.UnluckyVo;

import java.text.ParseException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sza
 * @since 2021-11-04
 */
public interface UnluckyService extends IService<Unlucky> {

    void addOrUpdateUnlucky(UnluckyVo unluckyVo) throws ParseException;

}
