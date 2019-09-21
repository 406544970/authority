package com.lh.authority.model.InPutParam;

import java.util.Date;
import java.util.List;

/**
 * @author ：ghj，后端工程师：gh，前端工程师：ghj
 * @create 2019-09-15 18:11
 * @function
 * @editLog
 */
public class PerUpdateInPutParam {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 主键, Where字段
     */
    private Integer idWhere;
    /**
     * 外键
     */
    private String perId;
    /**
     * 外键, Where字段
     */
    private String perIdWhere;
    /**
     * 科目名称
     */
    private String subjectName;
    /**
     * 科目名称, Where字段
     */
    private String subjectNameWhere;
    /**
     * 成绩
     */
    private Integer achievement;
    /**
     * 成绩, Where字段
     */
    private Integer achievementWhere;
    /**
     * 当前时间
     */
    private List<Date> workTime;
    /**
     * 当前时间, Where字段
     */
    private List<Date> workTimeWhere;

    public Integer getId(){
        return id;
    }
    public Integer getIdWhere(){
        return idWhere;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setIdWhere(Integer idWhere){
        this.idWhere = idWhere;
    }

    public String getPerId(){
        return perId;
    }
    public String getPerIdWhere(){
        return perIdWhere;
    }
    public void setPerId(String perId){
        this.perId = perId;
    }
    public void setPerIdWhere(String perIdWhere){
        this.perIdWhere = perIdWhere;
    }

    public String getSubjectName(){
        return subjectName;
    }
    public String getSubjectNameWhere(){
        return subjectNameWhere;
    }
    public void setSubjectName(String subjectName){
        this.subjectName = subjectName;
    }
    public void setSubjectNameWhere(String subjectNameWhere){
        this.subjectNameWhere = subjectNameWhere;
    }

    public Integer getAchievement(){
        return achievement;
    }
    public Integer getAchievementWhere(){
        return achievementWhere;
    }
    public void setAchievement(Integer achievement){
        this.achievement = achievement;
    }
    public void setAchievementWhere(Integer achievementWhere){
        this.achievementWhere = achievementWhere;
    }

    public List<Date> getWorkTime(){
        return workTime;
    }
    public List<Date> getWorkTimeWhere(){
        return workTimeWhere;
    }
    public void setWorkTime(List<Date> workTime){
        this.workTime = workTime;
    }
    public void setWorkTimeWhere(List<Date> workTimeWhere){
        this.workTimeWhere = workTimeWhere;
    }
}
