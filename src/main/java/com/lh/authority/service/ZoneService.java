package com.lh.authority.service;

import com.lh.authority.model.InPutParam.ZoneListInPutParam;
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
}
