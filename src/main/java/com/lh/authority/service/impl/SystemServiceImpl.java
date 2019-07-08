package com.lh.authority.service.impl;

import com.lh.VO.ResultVO;
import com.lh.authority.dao.OperatorMapper;
import com.lh.authority.dao.SystemMapper;
import com.lh.authority.dto.MyPage;
import com.lh.authority.model.*;
import com.lh.authority.service.SystemService;
import com.lh.authority.unit.MongodbNewJar;
import com.lh.authority.unit.MongodbOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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

    @Autowired
    OperatorMapper operatorMapper;
    @Autowired
    MongodbOperator mongodbOperator;

    @Autowired
    MongodbNewJar mongodbJar;

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

    /**
     * 根据用户ID，更新职位
     *
     * @param operatorAll
     * @return 影响行数
     */
    @Override
    public int updateByPrimaryKeyForJobName(OperatorAll operatorAll) {
        return operatorMapper.updateByPrimaryKeyForJobName(operatorAll);
    }

    /**
     * 登录方法
     *
     * @param num 工号(用工号作为登录用户名)
     * @return 返回状态
     */
    @Override
    public OperatorAll useLog(String num) {
        return operatorMapper.useLog(num);
    }

    @Override
    public boolean insertMongodb() {
        mongodbOperator.insertMongodb();
        return true;
    }

    @Override
    public int insertPatchData() {
        return mongodbOperator.insertPatchData();
    }

    @Override
    public int deleteMongodb() {
        return mongodbOperator.deleteMongodb();
    }

    @Override
    public ResultVO getLogModelList() throws ClassNotFoundException {
        return mongodbOperator.getLogModelListNew();
    }
    @Override
    public ResultVO getLogModelListNew() throws ClassNotFoundException, ParseException {
        return mongodbJar.getLogModelListNew();
    }

    @Override
    public void deleteCollect() {
//        mongodbJar.deleteCollect();
    }
}
