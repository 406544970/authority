package com.lh.authority.model;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-24 12:02
 * @function
 * @editLog
 */
public class UseMobileAndMailModel {
    /**
     * 逻辑主键
     */
    private String id;
    /**
     * 用户名（登录用户名）
     */
    private String username;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 是否停用（true停用 false不停用）
     */
    private transient Boolean stopSign;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Boolean getStopSign(){
        return stopSign;
    }

    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }
}

