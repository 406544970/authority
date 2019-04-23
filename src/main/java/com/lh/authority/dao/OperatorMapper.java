package com.lh.authority.dao;

import com.lh.authority.model.OperatorAll;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 梁昊
 * @date 2019/4/23
 * @function
 * @editLog
 */
@Mapper
public interface OperatorMapper {
    int updateByPrimaryKeyForJobName(OperatorAll operatorAll);
}
