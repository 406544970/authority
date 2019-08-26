package com.lh.authority.dto;

/**
 * @author ：梁昊
 * @create 2019-08-20 09:25
 * @function
 * @editLog
 */
public final class Per1Dto {
    /**
     *  姓名
     */
    private String name;
    /**
     *  性别（0：男、1：女）
     */
    private String sex;
    /**
     *  年龄
     */
    private Integer age;
    /**
     *  班级序号
     */
    private Integer classNo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

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
