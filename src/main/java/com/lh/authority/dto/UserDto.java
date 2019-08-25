package com.lh.authority.dto;

/**
 * @author ：梁昊，后端工程师：杨凯，前端工程师：陈盼
 * @create 2019-08-11 00:26
 * @function
 * @editLog
 */
public final class UserDto {
    /**
     * 主键
     */
    private String mainId;
    /**
     * 姓名
     */
    private String mainUserName;
    /**
     * 年龄
     */
    private Integer mainAge;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 主键
     */
    private String sub2Id;
    /**
     * 姓名
     */
    private String sub2UserName;
    /**
     * 年龄
     */
    private Integer sub2Age;

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public String getMainUserName() {
        return mainUserName;
    }

    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName;
    }

    public Integer getMainAge() {
        return mainAge;
    }

    public void setMainAge(Integer mainAge) {
        this.mainAge = mainAge;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSub2Id() {
        return sub2Id;
    }

    public void setSub2Id(String sub2Id) {
        this.sub2Id = sub2Id;
    }

    public String getSub2UserName() {
        return sub2UserName;
    }

    public void setSub2UserName(String sub2UserName) {
        this.sub2UserName = sub2UserName;
    }

    public Integer getSub2Age() {
        return sub2Age;
    }

    public void setSub2Age(Integer sub2Age) {
        this.sub2Age = sub2Age;
    }
}
