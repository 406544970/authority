package com.lh.authority.model;

import java.util.Date;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-19 12:43
 * @function
 * @editLog
 */
public class MyBatisUseModel {
    /**
     * 用户姓名
     */
    private String personName;
    /**
     * 登录手机号
     */
    private transient String mobile;
    /**
     * 密码
     */
    private transient String passWord;
    /**
     * 使用开始日期
     */
    private transient Date useBegin;
    /**
     * 使用结束日期
     */
    private transient Date useEnd;
    /**
     * 所在公司名称
     */
    private String companyName;
    /**
     * 是否停用
     */
    private Boolean stopSign;
    /**
     * 用户类型(0：后端，1：前端，2：设计)
     */
    private Integer useType;

    public String getPersonName(){
        return personName;
    }

    public void setPersonName(String personName){
        this.personName = personName;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public Date getUseBegin(){
        return useBegin;
    }

    public void setUseBegin(Date useBegin){
        this.useBegin = useBegin;
    }

    public Date getUseEnd(){
        return useEnd;
    }

    public void setUseEnd(Date useEnd){
        this.useEnd = useEnd;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public Boolean getStopSign(){
        return stopSign;
    }

    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }

    public Integer getUseType(){
        return useType;
    }

    public void setUseType(Integer useType){
        this.useType = useType;
    }
}
