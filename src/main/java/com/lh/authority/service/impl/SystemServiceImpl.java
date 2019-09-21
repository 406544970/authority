package com.lh.authority.service.impl;

import com.lh.authority.dao.SystemMapper;
import com.lh.authority.dto.MyPage;
import com.lh.authority.model.*;
import com.lh.authority.service.SystemService;
import lh.model.ResultVO;
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

    /**
     * 得到指定用户指定子系统页面权限列表
     *
     * @param mySystemParaAll 子系统输入参数类
     * @return 子系统页面权限列表
     */
    @Override
    public MyPage selectMyPageAuthorityList(MySystemParaAll mySystemParaAll) {
        return systemMapper.selectMyPageAuthorityList(mySystemParaAll);
    }


    @Override
    public boolean insertMongodb() {
//        mongodbOperator.insertMongodb();
        return true;
    }

    @Override
    public int insertPatchData() {
//        return mongodbOperator.insertPatchData();
        return 0;
    }

    @Override
    public int deleteMongodb() {
//        return mongodbOperator.deleteMongodb();
        return 0;
    }

    @Override
    public ResultVO getLogModelList() throws ClassNotFoundException {
//        return mongodbOperator.getLogModelListNew();
        return null;
    }

    @Override
    public void deleteCollect() {
//        mongodbJar.deleteCollect();
    }
}
