package com.lh.authority.model;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 得到用户子系统权限列表输入参数，包括指定子系统名称
 * @editLog
 */
public class MySystemParaAll extends MySystemPara {
    public MySystemParaAll() {
        super();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getPowerType() {
        return super.getPowerType();
    }

    @Override
    public void setPowerType(String powerType) {
        super.setPowerType(powerType);
    }

    @Override
    public String getFormType() {
        return super.getFormType();
    }

    @Override
    public void setFormType(String formType) {
        super.setFormType(formType);
    }

    @Override
    public String getStopSign() {
        return super.getStopSign();
    }

    private String systemName;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
