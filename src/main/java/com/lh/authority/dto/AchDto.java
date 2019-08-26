package com.lh.authority.dto;

/**
 * @author ：梁昊
 * @create 2019-08-20 09:18
 * @function
 * @editLog
 */
public final class AchDto {
    /**
     *  科目名称
     */
    private String subjectName;
    /**
     * 成绩
     */
    private Integer achievement;
    /**
     * 当前时间
     */
    private String workTime;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
}
