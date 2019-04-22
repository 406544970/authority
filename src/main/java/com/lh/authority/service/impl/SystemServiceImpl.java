package com.lh.authority.service.impl;

import com.lh.authority.dao.SystemMapper;
import com.lh.authority.model.MySystem;
import com.lh.authority.model.MySystemPara;
import com.lh.authority.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    SystemMapper systemMapper;

    /**
     * 得到指定用户子系统权限列表
     *
     * @param mySystemPara 子系统输入参数类
     * @return 子系统权限列表
     */
    @Override
    public List<MySystem> selectMySystemNameList(MySystemPara mySystemPara) {
        List<MySystem> mySystems = systemMapper.selectMySystemNameList(mySystemPara);
        return mySystems;
    }
}
