package com.lh.authority.dao;

import com.lh.authority.dto.Per1Dto;
import com.lh.authority.dto.PerDto;
import com.lh.authority.model.InPutParam.PerInPutParam;
import com.lh.authority.model.InPutParam.PerUpdateInPutParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：梁昊
 * @create 2019-08-19 10:51
 * @function
 * @editLog
 */
@Mapper
public interface PerMapper {
    /**
     * 1.	根据课程名和性别，统计出各科平均成绩、参加人次数、参加人数，并按平均成绩降序排序，性别排序
     *
     * @return 方法说明
     */
    List<PerDto> getPerAchList();

    /**
     * InnerJoin查询
     *
     * @param name 姓名
     * @return 方法说明
     */
    List<Per1Dto> getPerAchList2(@Param("name") String name);

    /**
     * 测试增加员工
     *
     * @param perInPutParam com.lh.authority.model.InPutParam.PerInPutParam
     * @return 员工主键
     */
    int insertIntoPerson(PerInPutParam perInPutParam);

    /**
     * 测试增加员工
     *
     * @param perInPutParam com.lh.authority.model.InPutParam.PerInPutParam
     * @return 员工主键
     */
    int insertIntoPersonBeforeCheck(PerInPutParam perInPutParam);
    /**
     * 更新方法
     *
     * @param perUpdateInPutParam ghj.model.InPutParam.PerUpdateInPutParam
     * @return 影响条件
     */
    int updatePerson(PerUpdateInPutParam perUpdateInPutParam);
}

