package com.lh.authority.model.InPutParam;

import java.util.Date;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-24 12:16
 * @function
 * @editLog
 */
public class UseUpdateInParam {
    /**
     * 逻辑主键
     */
    private String id;
    /**
     * 逻辑主键, Where字段
     */
    private String idWhere;
    /**
     * 部门ID
     */
    private String deptId;
    /**
     * 部门ID, Where字段
     */
    private String deptIdWhere;
    /**
     * 用户名（登录用户名）
     */
    private String username;
    /**
     * 用户名（登录用户名）, Where字段
     */
    private String usernameWhere;
    /**
     * 密码
     */
    private String password;
    /**
     * 密码, Where字段
     */
    private String passwordWhere;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户姓名, Where字段
     */
    private String nameWhere;
    /**
     * 英文名字
     */
    private String englishName;
    /**
     * 英文名字, Where字段
     */
    private String englishNameWhere;
    /**
     * 用户头像地址
     */
    private String portrait;
    /**
     * 用户头像地址, Where字段
     */
    private String portraitWhere;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 手机号码, Where字段
     */
    private String mobileWhere;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 联系电话, Where字段
     */
    private String telWhere;
    /**
     * QQ号码
     */
    private String qq;
    /**
     * QQ号码, Where字段
     */
    private String qqWhere;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 电子邮箱, Where字段
     */
    private String emailWhere;
    /**
     * 地址
     */
    private String address;
    /**
     * 地址, Where字段
     */
    private String addressWhere;
    /**
     * 邮政编码
     */
    private String postCode;
    /**
     * 邮政编码, Where字段
     */
    private String postCodeWhere;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 用户类型, Where字段
     */
    private String userTypeWhere;
    /**
     * 所属系统
     */
    private String systemName;
    /**
     * 所属系统, Where字段
     */
    private String systemNameWhere;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建时间, Where字段
     */
    private Date createTimeWhere;
    /**
     * 是否停用（true停用 false不停用）
     */
    private Boolean stopSign;
    /**
     * 是否停用（true停用 false不停用）, Where字段
     */
    private Boolean stopSignWhere;
    /**
     * 备注
     */
    private String remark;
    /**
     * 备注, Where字段
     */
    private String remarkWhere;

    public String getId(){
        return id;
    }
    public String getIdWhere(){
        return idWhere;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setIdWhere(String idWhere){
        this.idWhere = idWhere;
    }

    public String getDeptId(){
        return deptId;
    }
    public String getDeptIdWhere(){
        return deptIdWhere;
    }
    public void setDeptId(String deptId){
        this.deptId = deptId;
    }
    public void setDeptIdWhere(String deptIdWhere){
        this.deptIdWhere = deptIdWhere;
    }

    public String getUsername(){
        return username;
    }
    public String getUsernameWhere(){
        return usernameWhere;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setUsernameWhere(String usernameWhere){
        this.usernameWhere = usernameWhere;
    }

    public String getPassword(){
        return password;
    }
    public String getPasswordWhere(){
        return passwordWhere;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPasswordWhere(String passwordWhere){
        this.passwordWhere = passwordWhere;
    }

    public String getName(){
        return name;
    }
    public String getNameWhere(){
        return nameWhere;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setNameWhere(String nameWhere){
        this.nameWhere = nameWhere;
    }

    public String getEnglishName(){
        return englishName;
    }
    public String getEnglishNameWhere(){
        return englishNameWhere;
    }
    public void setEnglishName(String englishName){
        this.englishName = englishName;
    }
    public void setEnglishNameWhere(String englishNameWhere){
        this.englishNameWhere = englishNameWhere;
    }

    public String getPortrait(){
        return portrait;
    }
    public String getPortraitWhere(){
        return portraitWhere;
    }
    public void setPortrait(String portrait){
        this.portrait = portrait;
    }
    public void setPortraitWhere(String portraitWhere){
        this.portraitWhere = portraitWhere;
    }

    public String getMobile(){
        return mobile;
    }
    public String getMobileWhere(){
        return mobileWhere;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public void setMobileWhere(String mobileWhere){
        this.mobileWhere = mobileWhere;
    }

    public String getTel(){
        return tel;
    }
    public String getTelWhere(){
        return telWhere;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public void setTelWhere(String telWhere){
        this.telWhere = telWhere;
    }

    public String getQq(){
        return qq;
    }
    public String getQqWhere(){
        return qqWhere;
    }
    public void setQq(String qq){
        this.qq = qq;
    }
    public void setQqWhere(String qqWhere){
        this.qqWhere = qqWhere;
    }

    public String getEmail(){
        return email;
    }
    public String getEmailWhere(){
        return emailWhere;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setEmailWhere(String emailWhere){
        this.emailWhere = emailWhere;
    }

    public String getAddress(){
        return address;
    }
    public String getAddressWhere(){
        return addressWhere;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setAddressWhere(String addressWhere){
        this.addressWhere = addressWhere;
    }

    public String getPostCode(){
        return postCode;
    }
    public String getPostCodeWhere(){
        return postCodeWhere;
    }
    public void setPostCode(String postCode){
        this.postCode = postCode;
    }
    public void setPostCodeWhere(String postCodeWhere){
        this.postCodeWhere = postCodeWhere;
    }

    public String getUserType(){
        return userType;
    }
    public String getUserTypeWhere(){
        return userTypeWhere;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }
    public void setUserTypeWhere(String userTypeWhere){
        this.userTypeWhere = userTypeWhere;
    }

    public String getSystemName(){
        return systemName;
    }
    public String getSystemNameWhere(){
        return systemNameWhere;
    }
    public void setSystemName(String systemName){
        this.systemName = systemName;
    }
    public void setSystemNameWhere(String systemNameWhere){
        this.systemNameWhere = systemNameWhere;
    }

    public Date getCreateTime(){
        return createTime;
    }
    public Date getCreateTimeWhere(){
        return createTimeWhere;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    public void setCreateTimeWhere(Date createTimeWhere){
        this.createTimeWhere = createTimeWhere;
    }

    public Boolean getStopSign(){
        return stopSign;
    }
    public Boolean getStopSignWhere(){
        return stopSignWhere;
    }
    public void setStopSign(Boolean stopSign){
        this.stopSign = stopSign;
    }
    public void setStopSignWhere(Boolean stopSignWhere){
        this.stopSignWhere = stopSignWhere;
    }

    public String getRemark(){
        return remark;
    }
    public String getRemarkWhere(){
        return remarkWhere;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public void setRemarkWhere(String remarkWhere){
        this.remarkWhere = remarkWhere;
    }
}
