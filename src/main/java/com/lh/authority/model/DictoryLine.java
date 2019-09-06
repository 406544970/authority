package com.lh.authority.model;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：陈盼
 * @create 2019-09-05 15:27
 * @function
 * @editLog
 */
public class DictoryLine {
    /**
     * 主键
     */
    private String value;
    /**
     * 内容
     */
    private String label;
    /**
     * 是否选择（0：不选择，1：选择）
     */
    private Integer defaultSelect;

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

    public Integer getDefaultSelect(){
        return defaultSelect;
    }

    public void setDefaultSelect(Integer defaultSelect){
        this.defaultSelect = defaultSelect;
    }
}
