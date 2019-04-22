package com.lh.authority.model;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 子系统分组
 * @editLog
 */
public class Group {
    private String groupName;
    private Boolean expandSign;

    private List<PageItem> pageItems;


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Boolean getExpandSign() {
        return expandSign;
    }

    public void setExpandSign(Boolean expandSign) {
        this.expandSign = expandSign;
    }

    public List<PageItem> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<PageItem> pageItems) {
        this.pageItems = pageItems;
    }
}
