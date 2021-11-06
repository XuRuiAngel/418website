package com.sza.website.service.impl;

import com.sza.website.entity.Unlucky;
import com.sza.website.mapper.UnluckyMapper;
import com.sza.website.service.UnluckyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sza.website.util.BeanCopyUtils;
import com.sza.website.vo.UnluckyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sza
 * @since 2021-11-04
 */
@Service
public class UnluckyServiceImpl extends ServiceImpl<UnluckyMapper, Unlucky> implements UnluckyService {

    @Autowired
    UnluckyMapper unluckyMapper;

    @Autowired
    UnluckyService unluckyService;

    @Override
    public void addOrUpdateUnlucky(UnluckyVo unluckyVo) throws ParseException {
        Unlucky unlucky = BeanCopyUtils.copyObject(unluckyVo, Unlucky.class);
        unlucky.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(unluckyVo.getTime()));
        unlucky.setDeleted(0);
        unluckyService.saveOrUpdate(unlucky);
    }
}
