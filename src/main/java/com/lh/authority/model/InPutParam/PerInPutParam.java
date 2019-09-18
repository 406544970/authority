package com.lh.authority.model.InPutParam;

/**
 * @author ：hj，后端工程师：hj，前端工程师：hj
 * @create 2019-09-12 21:49
 * @function
 * @editLog
 */
public class PerInPutParam {
    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别（0：男、1：女）
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 班级序号
     */
    private Integer classNo;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getSex(){
        return sex;
    }

    public void setSex(Integer sex){
        this.sex = sex;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public Integer getClassNo(){
        return classNo;
    }

    public void setClassNo(Integer classNo){
        this.classNo = classNo;
    }
}
