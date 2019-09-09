package com.lh.authority.service;

import com.lh.authority.dto.UseDto;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:43
 * @function
 * @editLog
 */
public interface UseService {
    /**
     * 描述
     *
     * @param id
     * @return 返回值说明
     */
    List<UseDto> getNewUseListPage(String id);
}
