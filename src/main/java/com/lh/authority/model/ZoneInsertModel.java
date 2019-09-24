package com.lh.authority.model;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-07 17:27
 * @function
 * @editLog
 */
public class ZoneInsertModel {
    /**
     * 主键
     */
    private String id;
    /**
     * 地区名称
     */
    private String label;
    /**
     * 拼音码
     */
    private String pinYin;
    /**
     * 级别
     */
    private Integer classIndex;
    /**
     * 父ID
     */
    private String paraId;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public Integer getClassIndex(){
        return classIndex;
    }

    public void setClassIndex(Integer classIndex){
        this.classIndex = classIndex;
    }

    public String getParaId(){
        return paraId;
    }

    public void setParaId(String paraId){
        this.paraId = paraId;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }
}
