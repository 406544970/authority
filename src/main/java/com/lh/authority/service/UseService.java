package com.lh.authority.service;

import com.lh.authority.dto.UseDto;
import com.lh.authority.model.InPutParam.*;
import com.lh.authority.model.UseMobileAndMailModel;
import com.lh.authority.model.UseModel;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:43
 * @function
 * @editLog
 */
public interface UseService {
    /**
     * 描述
     *
     * @param id
     * @return 返回值说明
     */
    List<UseDto> getNewUseListPage(String id);
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
    UseModel useLogByNameAndPassWord(String mobile);
    /**
     * 根据标识得到内容
     *
     * @param useSelectMobileAndMailInParam 根据标识得到内容
     * @return 内容
     */
    UseMobileAndMailModel getMobileAndMailBy(UseSelectMobileAndMailInParam useSelectMobileAndMailInParam);
    /**
     * 修改密码
     *
     * @param useUpdateInParam com.lh.authority.model.InPutParam.UseUpdateInParam
     * @return 结构体
     */
    int updatePassWordById(UseUpdateInParam useUpdateInParam);
    /**
     * 根据GUID，得到用户ID
     *
     * @param guid guid
     * @return UseID
     */
    String getUseIdByGuid(String guid);
    /**
     * 增加忘记密码申请
     *
     * @param useInsertForGet com.lh.authority.model.InPutParam.UseInsertForGet
     * @return 是否已增加
     */
    int insertForGetPassWordRecord(UseInsertForGet useInsertForGet);
    /**
     * 根据UseId，删除忘记密码记录
     *
     * @param useDeletePassWordInParam com.lh.authority.model.InPutParam.UseDeletePassWordInParam
     * @return 影响条件
     */
    int deletePassWordRecordByUseId(UseDeletePassWordInParam useDeletePassWordInParam);

}
