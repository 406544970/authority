package com.lh.authority.model;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-08 14:16
 * @function
 * @editLog
 */
public class ZoneListModel {
    /**
     * 主键
     */
    private String value;
    /**
     * 地区名称
     */
    private String label;
    /**
     * 拼音码
     */
    private String pingYin;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getPingYin(){
        return pingYin;
    }

    public void setPingYin(String pingYin){
        this.pingYin = pingYin;
    }
}

