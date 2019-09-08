package com.lh.authority.model.InPutParam;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-08 14:18
 * @function
 * @editLog
 */
public class ZoneListInPutParam {
    /**
     * 表inf_zone,字段名classIndex:级别
     */
    private Integer classIndex;
    /**
     * 表inf_zone,字段名paraId:父ID
     */
    private String paraId;

    public Integer getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(Integer classIndex) {
        this.classIndex = classIndex;
    }

    public String getParaId() {
        return paraId;
    }

    public void setParaId(String paraId) {
        this.paraId = paraId;
    }
}
