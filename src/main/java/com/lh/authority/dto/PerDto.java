package com.lh.authority.dto;

/**
 * @author ：梁昊
 * @create 2019-08-19 10:51
 * @function
 * @editLog
 */
public final class PerDto {
    /**
     * 主键
     */
    private Integer countId;
    /**
     *  性别（0：男、1：女）
     */
    private Integer sex;
    /**
     * 成绩
     */
    private Integer achievement;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     *  科目名称
     */
    private String subjectName;


    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
        this.countId = countId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }
}
