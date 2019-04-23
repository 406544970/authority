package com.lh.authority.service;


import com.lh.authority.dto.MyPage;
import com.lh.authority.model.MySystem;
import com.lh.authority.model.MySystemPara;
import com.lh.authority.model.MySystemParaAll;
import com.lh.authority.model.OperatorAll;

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
}
