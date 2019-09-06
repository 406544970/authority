package com.lh.authority.service;

import com.lh.authority.model.DictoryLine;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：陈盼
 * @create 2019-09-05 15:27
 * @function
 * @editLog
 */
public interface DictoryLineService {
    /**
     * 返回线性数据字典
     *
     * @param signName 标识
     * @return 数据字典LIST
     */
    List<DictoryLine> getDictoryList(String signName);
}
