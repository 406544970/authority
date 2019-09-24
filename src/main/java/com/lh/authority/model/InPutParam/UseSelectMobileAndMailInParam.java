package com.lh.authority.model.InPutParam;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-24 11:58
 * @function
 * @editLog
 */
public class UseSelectMobileAndMailInParam {
    /**
     * 表sys_userinfo,字段名username:用户名（登录用户名）
     */
    private String username;
    /**
     * 表sys_userinfo,字段名mobile:手机号码
     */
    private String mobile;
    /**
     * 表sys_userinfo,字段名email:电子邮箱
     */
    private String email;

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
}
