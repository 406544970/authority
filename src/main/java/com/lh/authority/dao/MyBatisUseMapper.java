package com.lh.authority.dao;

import com.lh.authority.model.MyBatisUseModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-19 12:35
 * @function
 * @editLog
 */
@Mapper
public interface MyBatisUseMapper {
    /**
     * 用户登录
     *
     * @param mobile 登录手机号
     * @return 结构体
     */
    MyBatisUseModel useLogByNameAndPassWord(@Param("mobile") String mobile);
}
