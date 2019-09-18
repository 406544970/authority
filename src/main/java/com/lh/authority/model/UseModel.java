package com.lh.authority.model;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-18 15:44
 * @function
 * @editLog
 */
public class UseModel {
    /**
     * 逻辑主键
     */
    private String id;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 是否停用（true停用 false不停用）
     */
    private Boolean stopSign;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getUserType(){
        return userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public Boolean getStopSign(){
        return stopSign;
    }

    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }
}

