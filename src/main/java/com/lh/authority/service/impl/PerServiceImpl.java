package com.lh.authority.service.impl;

import com.lh.authority.dao.PerMapper;
import com.lh.authority.dto.Per1Dto;
import com.lh.authority.dto.PerDto;
import com.lh.authority.model.InPutParam.PerInPutParam;
import com.lh.authority.model.InPutParam.PerUpdateInPutParam;
import com.lh.authority.service.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：梁昊
 * @create 2019-08-19 10:53
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class PerServiceImpl implements PerService {
    @Autowired
    PerMapper perMapper;

    /**
     * 1.	根据课程名和性别，统计出各科平均成绩、参加人次数、参加人数，并按平均成绩降序排序，性别排序
     *
     * @return 方法说明
     */
    @Override
    public List<PerDto> getPerAchList() {
        return perMapper.getPerAchList();
    }

    /**
     * InnerJoin查询
     *
     * @param name 姓名
     * @return 方法说明
     */
    @Override
    public List<Per1Dto> getPerAchList2(String name) {
        return perMapper.getPerAchList2(name);
    }

    /**
     * 测试增加员工
     *
     * @param perInPutParam com.lh.authority.model.InPutParam.PerInPutParam
     * @return 员工主键
     */
    @Override
    public int insertIntoPerson(PerInPutParam perInPutParam) {
        return perMapper.insertIntoPerson(perInPutParam);
    }
    /**
     * 测试增加员工
     *
     * @param perInPutParam com.lh.authority.model.InPutParam.PerInPutParam
     * @return 员工主键
     */
    @Override
    public int insertIntoPersonBeforeCheck(PerInPutParam perInPutParam) {
        return perMapper.insertIntoPersonBeforeCheck(perInPutParam);
    }
    /**
     * 更新方法
     *
     * @param perUpdateInPutParam ghj.model.InPutParam.PerUpdateInPutParam
     * @return 影响条件
     */
    @Override
    public int updatePerson (PerUpdateInPutParam perUpdateInPutParam) {
        return perMapper.updatePerson(perUpdateInPutParam);
    }
}

