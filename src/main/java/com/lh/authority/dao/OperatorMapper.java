package com.lh.authority.dao;

import com.lh.authority.model.OperatorAll;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 梁昊
 * @date 2019/4/23
 * @function
 * @editLog
 */
@Mapper
public interface OperatorMapper {
    int updateByPrimaryKeyForJobName(OperatorAll operatorAll);

    /**
     * 登录方法
     *
     * @param num 工号(用工号作为登录用户名)
     * @return 返回状态
     */
    OperatorAll useLog(@Param("num") String num);
}
