package com.lh.authority.service.impl;

import com.lh.authority.dao.ZoneMapper;
import com.lh.authority.model.InPutParam.ZoneDeleteInParam;
import com.lh.authority.model.InPutParam.ZoneInsertInParam;
import com.lh.authority.model.InPutParam.ZoneListInPutParam;
import com.lh.authority.model.InPutParam.ZoneUpdateInParam;
import com.lh.authority.model.ZoneInsertModel;
import com.lh.authority.model.ZoneListModel;
import com.lh.authority.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-07 17:30
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    ZoneMapper zoneMapper;
    /**
     * 加入单条地区信息
     *
     * @param zoneInsertModel 加入单条地区信息
     * @return 影响条数
     */
    @Override
    public int insertZoneAlone(ZoneInsertModel zoneInsertModel) {
        return zoneMapper.insertZoneAlone(zoneInsertModel);
    }
    /**
     * 生成地区下拉框查询
     *
     * @param zoneListInPutParam 生成地区下拉框查询
     * @return 下拉框数据
     */
    @Override
    public List<ZoneListModel> getZoneList(ZoneListInPutParam zoneListInPutParam) {
        return zoneMapper.getZoneList(zoneListInPutParam);
    }

    /**
     * 增加地区
     *
     * @param zoneInsertInParam com.lh.authority.model.InPutParam.ZoneInsertInParam
     * @return 影响条数
     */
    @Override
    public int insertZone (ZoneInsertInParam zoneInsertInParam) {
        return zoneMapper.insertZone(zoneInsertInParam);
    }

    /**
     * 增加地区
     *
     * @param zoneInsertInParam com.lh.authority.model.InPutParam.ZoneInsertInParam
     * @return 影响条数
     */
    @Override
    public int insertZoneBeforeCheck(ZoneInsertInParam zoneInsertInParam) {
        return zoneMapper.insertZoneBeforeCheck(zoneInsertInParam);
    }

    /**
     * 删除
     *
     * @param zoneDeleteInParam com.lh.authority.model.InPutParam.ZoneDeleteInParam
     * @return 影响条数
     */
    @Override
    public int deleteZoneById (ZoneDeleteInParam zoneDeleteInParam) {
        return zoneMapper.deleteZoneById(zoneDeleteInParam);
    }

    @Override
    public int deleteZoneBeforeCheck(ZoneDeleteInParam zoneDeleteInParam) {
        return zoneMapper.deleteZoneBeforeCheck(zoneDeleteInParam);
    }

    /**
     * 修改地区
     *
     * @param zoneUpdateInParam com.lh.authority.model.InPutParam.ZoneUpdateInParam
     * @return 影响条数
     */
    @Override
    public int updateZone (ZoneUpdateInParam zoneUpdateInParam) {
        return zoneMapper.updateZone(zoneUpdateInParam);
    }
    /**
     * 根据父ID判断是否有子节点
     *
     * @param paraId 父ID
     * @return 子节点ID列表
     */
    @Override
    public List<String> selectZoneByParaId(String paraId) {
        return zoneMapper.selectZoneByParaId(paraId);
    }

}
