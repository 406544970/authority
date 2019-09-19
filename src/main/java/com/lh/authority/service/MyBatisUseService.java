package com.lh.authority.service;

import com.lh.authority.model.MyBatisUseModel;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-19 12:35
 * @function
 * @editLog
 */
public interface MyBatisUseService {
    /**
     * 用户登录
     *
     * @param mobile 登录手机号
     * @return 结构体
     */
    MyBatisUseModel useLogByNameAndPassWord(String mobile);
}
