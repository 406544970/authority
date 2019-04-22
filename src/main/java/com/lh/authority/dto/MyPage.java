package com.lh.authority.dto;

import com.lh.authority.model.Group;
import com.lh.authority.model.MySystem;
import com.lh.authority.model.Operator;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 子系统所有权限信息
 * @editLog
 */
public class MyPage extends MySystem {
    private Operator operator;
    private List<Group> groups;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
