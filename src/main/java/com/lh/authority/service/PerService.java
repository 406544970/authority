package com.lh.authority.service;

import com.lh.authority.dto.Per1Dto;
import com.lh.authority.dto.PerDto;

import java.util.List;

/**
 * @author ：梁昊
 * @create 2019-08-19 10:53
 * @function
 * @editLog
 */
public interface PerService {
    /**
     * 1.	根据课程名和性别，统计出各科平均成绩、参加人次数、参加人数，并按平均成绩降序排序，性别排序
     *
     * @return 方法说明
     */
    List<PerDto> getPerAchList();
    /**
     * InnerJoin查询
     *
     * @param name  姓名
     * @return 方法说明
     */
    List<Per1Dto> getPerAchList2(String name);
}

