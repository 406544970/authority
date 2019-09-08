package com.lh.authority.service.impl;

import com.lh.authority.dao.ZoneMapper;
import com.lh.authority.model.InPutParam.ZoneListInPutParam;
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
}
