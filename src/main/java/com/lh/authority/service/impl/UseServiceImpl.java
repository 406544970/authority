package com.lh.authority.service.impl;

import com.lh.authority.dao.UseMapper;
import com.lh.authority.dto.UseDto;
import com.lh.authority.model.InPutParam.UseInsertInParam;
import com.lh.authority.model.UseModel;
import com.lh.authority.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:43
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UseServiceImpl implements UseService {
    @Autowired
    UseMapper useMapper;
    /**
     * 描述
     *
     * @param id
     * @return 返回值说明
     */
    @Override
    public List<UseDto> getNewUseListPage(String id) {
        return useMapper.getNewUseListPage(id);
    }
    /**
     * 增加新用户
     *
     * @param useInsertInParam com.lh.authority.model.InPutParam.UseInsertInParam
     * @return 影响条数
     */
    @Override
    public int AddNewUse (UseInsertInParam useInsertInParam) {
        return useMapper.AddNewUse(useInsertInParam);
    }

    /**
     * 增加新用户
     *
     * @param useInsertInParam com.lh.authority.model.InPutParam.UseInsertInParam
     * @return 影响条数
     */
    @Override
    public int AddNewUseBeforeCheck(UseInsertInParam useInsertInParam) {
        return useMapper.AddNewUseBeforeCheck(useInsertInParam);
    }
    /**
     * 用户登录
     *
     * @param mobile 手机号码
     * @return 结构体
     */
    @Override
    public UseModel useLogByNameAndPassWord(String mobile) {
        return useMapper.useLogByNameAndPassWord(mobile);
    }

}
