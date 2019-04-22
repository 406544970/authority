package com.lh.authority.dao;

import com.lh.authority.model.MySystem;
import com.lh.authority.model.MySystemPara;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function
 * @editLog
 */
@Mapper
public interface SystemMapper {
    List<MySystem> selectMySystemNameList(MySystemPara mySystemPara);
}
