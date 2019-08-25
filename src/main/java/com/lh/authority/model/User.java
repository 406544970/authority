package com.lh.authority.model;

import java.util.Date;

/**
 * @author ：
 * @create 2019-08-10 22:46
 * @function
 * @editLog
 */
public class User  {
    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
