package com.lh.authority.model;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 得到用户子系统权限列表输入参数
 * @editLog
 */
public class MySystemPara {
    private String id;
    private String powerType;
    private String formType;
    private String stopSign;

    public MySystemPara() {
        super();
        this.formType = "BS";
        this.powerType = "item";
        this.stopSign = "0";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getStopSign() {
        return stopSign;
    }
}
