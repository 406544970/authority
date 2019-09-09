package com.lh.authority.dao;

import com.lh.authority.dto.UseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:41
 * @function
 * @editLog
 */
@Mapper
public interface UseMapper {
    /**
     * 描述
     *
     * @param id
     * @return 返回值说明
     */
    List<UseDto> getNewUseListPage(@Param("id") String id);
}
