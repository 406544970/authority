package com.lh.authority.model;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function
 * @editLog
 */
public class Operator {
    private String operatorId;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    private String operName;
    private String departId;
}
