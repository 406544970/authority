package com.lh.authority.service;

import com.lh.authority.model.InPutParam.ZoneDeleteInParam;
import com.lh.authority.model.InPutParam.ZoneInsertInParam;
import com.lh.authority.model.InPutParam.ZoneListInPutParam;
import com.lh.authority.model.InPutParam.ZoneUpdateInParam;
import com.lh.authority.model.ZoneInsertModel;
import com.lh.authority.model.ZoneListModel;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-07 17:30
 * @function
 * @editLog
 */
public interface ZoneService {
    /**
     * 加入单条地区信息
     *
     * @param zoneInsertModel 加入单条地区信息
     * @return 影响条数
     */
    int insertZoneAlone(ZoneInsertModel zoneInsertModel);
    /**
     * 生成地区下拉框查询
     *
     * @param zoneListInPutParam 生成地区下拉框查询
     * @return 下拉框数据
     */
    List<ZoneListModel> getZoneList(ZoneListInPutParam zoneListInPutParam);
    /**
     * 增加地区
     *
     * @param zoneInsertInParam com.lh.authority.model.InPutParam.ZoneInsertInParam
     * @return 影响条数
     */
    int insertZone(ZoneInsertInParam zoneInsertInParam);

    /**
     * 增加地区
     *
     * @param zoneInsertInParam com.lh.authority.model.InPutParam.ZoneInsertInParam
     * @return 影响条数
     */
    int insertZoneBeforeCheck(ZoneInsertInParam zoneInsertInParam);
    /**
     * 删除
     *
     * @param zoneDeleteInParam com.lh.authority.model.InPutParam.ZoneDeleteInParam
     * @return 影响条数
     */
    int deleteZoneById(ZoneDeleteInParam zoneDeleteInParam);
    /**
     * 增加地区
     *
     * @param zoneDeleteInParam com.lh.authority.model.InPutParam.zoneDeleteInParam
     * @return 影响条数
     */
    int deleteZoneBeforeCheck(ZoneDeleteInParam zoneDeleteInParam);
    /**
     * 修改地区
     *
     * @param zoneUpdateInParam com.lh.authority.model.InPutParam.ZoneUpdateInParam
     * @return 影响条数
     */
    int updateZone(ZoneUpdateInParam zoneUpdateInParam);
    /**
     * 根据父ID判断是否有子节点
     *
     * @param paraId 父ID
     * @return 子节点ID列表
     */
    List<String> selectZoneByParaId(String paraId);


}
