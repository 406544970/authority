package com.lh.authority.dao;

import com.lh.authority.model.DictoryLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：陈盼
 * @create 2019-09-05 15:27
 * @function
 * @editLog
 */
@Mapper
public interface DictoryLineMapper {
    /**
     * 返回线性数据字典
     *
     * @param signName 标识
     * @return 数据字典LIST
     */
    List<DictoryLine> getDictoryList(@Param("signName") String signName);
}
