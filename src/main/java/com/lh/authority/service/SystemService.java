package com.lh.authority.service;


import com.lh.VO.ResultVO;
import com.lh.authority.dto.MyPage;
import com.lh.authority.model.*;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function
 * @editLog
 */
public interface SystemService {
    /**
     * 得到指定用户子系统权限列表
     *
     * @param mySystemPara 子系统输入参数类
     * @return 子系统权限列表
     */
    List<MySystem> selectMySystemNameList(MySystemPara mySystemPara);

    MyPage selectMyPageAuthorityList(MySystemParaAll mySystemParaAll);

    int updateByPrimaryKeyForJobName(OperatorAll operatorAll);

    /**
     * 登录方法
     *
     * @param num 工号(用工号作为登录用户名)
     * @return 返回状态
     */
    OperatorAll useLog(String num);
    boolean insertMongodb();
    int insertPatchData();
    int deleteMongodb();
    ResultVO getLogModelList() throws ClassNotFoundException;
}
