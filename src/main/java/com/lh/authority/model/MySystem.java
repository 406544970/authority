package com.lh.authority.model;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 用户子系统权限列表
 * @editLog
 */
public class MySystem {
    private String systemName;
    private String picPath;
    private String remark;
    private Integer enableSign;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnableSign() {
        return enableSign;
    }

    public void setEnableSign(Integer enableSign) {
        this.enableSign = enableSign;
    }
}
