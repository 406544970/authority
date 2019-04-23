package com.lh.authority.model;

import java.util.Date;

/**
 * @author 梁昊
 * @create 2019-04-23 10:50
 * @function
 * @editLog
 */
public class OperatorAll  {

    /**
     * 主键
     */
    private String id;
    /**
     * 工号(用工号作为登录用户名)
     */
    private String num;
    /**
     * 姓名
     */
    private String name;
    /**
     * 英文名
     */
    private String eName;
    /**
     * 身份证号
     */
    private String identityCode;
    /**
     * 登录密码
     */
    private String pwd;
    /**
     * 数据范围ID
     */
    private String dataRangeId;
    /**
     * 职位名
     */
    private String jobName;
    /**
     * 用户类型（系统管理员、起点内部员工）
     */
    private String operatorType;
    /**
     * 用户部门ID
     */
    private String departId;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 办公电话
     */
    private String tel;
    /**
     * 商务手机
     */
    private String businessTel;
    /**
     * 扣扣
     */
    private String qq;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮政编码
     */
    private String postalCode;
    /**
     * 数据生成日期
     */
    private Date workDate;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 是否停用
     */
    private Boolean stopSign;
    /**
     * 入职日期
     */
    private Date intoJobDate;
    /**
     * 离职日期
     */
    private Date outJobDate;
    /**
     * 备注
     */
    private String remark;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDataRangeId() {
        return dataRangeId;
    }

    public void setDataRangeId(String dataRangeId) {
        this.dataRangeId = dataRangeId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBusinessTel() {
        return businessTel;
    }

    public void setBusinessTel(String businessTel) {
        this.businessTel = businessTel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getStopSign() {
        return stopSign;
    }

    public void setStopSign(Boolean stopSign) {
        this.stopSign = stopSign;
    }

    public Date getIntoJobDate() {
        return intoJobDate;
    }

    public void setIntoJobDate(Date intoJobDate) {
        this.intoJobDate = intoJobDate;
    }

    public Date getOutJobDate() {
        return outJobDate;
    }

    public void setOutJobDate(Date outJobDate) {
        this.outJobDate = outJobDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
