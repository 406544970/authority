package com.lh.authority.model.InPutParam;


import java.util.Date;

/**
 * @author ：k，后端工程师：k，前端工程师：k
 * @create 2019-09-18 15:07
 * @function
 * @editLog
 */
public class UseInsertInParam {
    /**
     * 逻辑主键
     */
    private String id;
    /**
     * 部门ID
     */
    private String deptId;
    /**
     * 用户名（登录用户名）
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 英文名字
     */
    private String englishName;
    /**
     * 用户头像地址
     */
    private String portrait;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * QQ号码
     */
    private String qq;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮政编码
     */
    private String postCode;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否停用（true停用 false不停用）
     */
    private Boolean stopSign;
    /**
     * 备注
     */
    private String remark;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getDeptId(){
        return deptId;
    }

    public void setDeptId(String deptId){
        this.deptId = deptId;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEnglishName(){
        return englishName;
    }

    public void setEnglishName(String englishName){
        this.englishName = englishName;
    }

    public String getPortrait(){
        return portrait;
    }

    public void setPortrait(String portrait){
        this.portrait = portrait;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getTel(){
        return tel;
    }

    public void setTel(String tel){
        this.tel = tel;
    }

    public String getQq(){
        return qq;
    }

    public void setQq(String qq){
        this.qq = qq;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPostCode(){
        return postCode;
    }

    public void setPostCode(String postCode){
        this.postCode = postCode;
    }

    public String getUserType(){
        return userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Boolean getStopSign(){
        return stopSign;
    }

    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }
}
