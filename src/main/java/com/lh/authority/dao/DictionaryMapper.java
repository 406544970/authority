package com.lh.authority.dao;

import com.lh.authority.model.DictionaryModel;
import com.lh.authority.model.InPutParam.DictionaryInsertInParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-21 23:21
 * @function
 * @editLog
 */
@Mapper
public interface DictionaryMapper {
    /**
     * 返回字典列表
     *
     * @param signName 标识
     * @return List
     */
    List<DictionaryModel> selectDictionaryList(@Param("signName") String signName);
    /**
     * 增加字典
     *
     * @param dictionaryInsertInParam com.lh.authority.model.InPutParam.DictionaryInsertInParam
     * @return 影响条数
     */
    int insertDictionary(DictionaryInsertInParam dictionaryInsertInParam);

    /**
     * 增加字典
     *
     * @param dictionaryInsertInParam com.lh.authority.model.InPutParam.DictionaryInsertInParam
     * @return 影响条数
     */
    int insertDictionaryBeforeCheck(DictionaryInsertInParam dictionaryInsertInParam);

}