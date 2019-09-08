package com.lh.authority.dao;

import com.lh.authority.model.InPutParam.ZoneListInPutParam;
import com.lh.authority.model.ZoneInsertModel;
import com.lh.authority.model.ZoneListModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-07 17:27
 * @function
 * @editLog
 */
@Mapper
public interface ZoneMapper {
    /**
     * 加入单条地区信息
     *
     * @return 影响条数
     */
    int insertZoneAlone(ZoneInsertModel zoneInsertModel);
    /**
     * 生成地区下拉框查询
     *
     * @param zoneListInPutParam 输入参数
     * @return 下拉框数据
     */
    List<ZoneListModel> getZoneList(ZoneListInPutParam zoneListInPutParam);
}
