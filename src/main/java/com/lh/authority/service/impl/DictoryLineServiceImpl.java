package com.lh.authority.service.impl;

import com.lh.authority.dao.DictoryLineMapper;
import com.lh.authority.model.DictoryLine;
import com.lh.authority.service.DictoryLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：陈盼
 * @create 2019-09-05 15:27
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class DictoryLineServiceImpl implements DictoryLineService {
    @Autowired
    DictoryLineMapper dictoryLineMapper;
    /**
     * 返回线性数据字典
     *
     * @param signName 标识
     * @return 数据字典LIST
     */
    @Override
    public List<DictoryLine> getDictoryList(String signName) {
        return dictoryLineMapper.getDictoryList(signName);
    }
}
