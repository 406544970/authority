package com.lh.authority.service.impl;

import com.lh.authority.dao.MyBatisUseMapper;
import com.lh.authority.model.MyBatisUseModel;
import com.lh.authority.service.MyBatisUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-19 12:35
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class MyBatisUseServiceImpl implements MyBatisUseService {
    @Autowired
    MyBatisUseMapper myBatisUseMapper;
    /**
     * 用户登录
     *
     * @param mobile 登录手机号
     * @return 结构体
     */
    @Override
    public MyBatisUseModel useLogByNameAndPassWord(String mobile) {
        return myBatisUseMapper.useLogByNameAndPassWord(mobile);
    }
}
