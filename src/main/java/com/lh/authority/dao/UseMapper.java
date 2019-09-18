package com.lh.authority.dao;

import com.lh.authority.dto.UseDto;
import com.lh.authority.model.InPutParam.UseInsertInParam;
import com.lh.authority.model.UseModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:41
 * @function
 * @editLog
 */
@Mapper
public interface UseMapper {
    /**
     * 描述
     *
     * @param id
     * @return 返回值说明
     */
    List<UseDto> getNewUseListPage(@Param("id") String id);
    /**
     * 增加新用户
     *
     * @param useInsertInParam com.lh.authority.model.InPutParam.UseInsertInParam
     * @return 影响条数
     */
    int AddNewUse(UseInsertInParam useInsertInParam);

    /**
     * 增加新用户
     *
     * @param useInsertInParam com.lh.authority.model.InPutParam.UseInsertInParam
     * @return 影响条数
     */
    int AddNewUseBeforeCheck(UseInsertInParam useInsertInParam);
    /**
     * 用户登录
     *
     * @param mobile 手机号码
     * @return 结构体
     */
    UseModel useLogByNameAndPassWord(@Param("mobile") String mobile);

}
