package com.lh.authority.service.impl;

import com.lh.authority.dao.UseMapper;
import com.lh.authority.dto.UseDto;
import com.lh.authority.model.InPutParam.*;
import com.lh.authority.model.UseMobileAndMailModel;
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
    /**
     * 根据标识得到内容
     *
     * @param useSelectMobileAndMailInParam 根据标识得到内容
     * @return 内容
     */
    @Override
    public UseMobileAndMailModel getMobileAndMailBy(UseSelectMobileAndMailInParam useSelectMobileAndMailInParam) {
        return useMapper.getMobileAndMailBy(useSelectMobileAndMailInParam);
    }

    /**
     * 修改密码
     *
     * @param useUpdateInParam com.lh.authority.model.InPutParam.UseUpdateInParam
     * @return 结构体
     */
    @Override
    public int updatePassWordById (UseUpdateInParam useUpdateInParam) {
        return useMapper.updatePassWordById(useUpdateInParam);
    }
    /**
     * 根据GUID，得到用户ID
     *
     * @param guid guid
     * @return UseID
     */
    @Override
    public String getUseIdByGuid(String guid) {
        return useMapper.getUseIdByGuid(guid);
    }

    /**
     * 增加忘记密码申请
     *
     * @param useInsertForGet com.lh.authority.model.InPutParam.UseInsertForGet
     * @return 是否已增加
     */
    @Override
    public int insertForGetPassWordRecord (ZoneUpdateInParam.UseInsertForGet useInsertForGet) {
        return useMapper.insertForGetPassWordRecord(useInsertForGet);
    }

    /**
     * 根据UseId，删除忘记密码记录
     *
     * @param useDeletePassWordInParam com.lh.authority.model.InPutParam.UseDeletePassWordInParam
     * @return 影响条件
     */
    @Override
    public int deletePassWordRecordByUseId (UseDeletePassWordInParam useDeletePassWordInParam) {
        return useMapper.deletePassWordRecordByUseId(useDeletePassWordInParam);
    }

}
