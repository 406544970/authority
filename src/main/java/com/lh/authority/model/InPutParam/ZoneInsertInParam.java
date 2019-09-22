package com.lh.authority.model.InPutParam;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-22 14:59
 * @function
 * @editLog
 */
public class ZoneInsertInParam {
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
    private String pinyYin;
    /**
     * 级别
     */
    private Integer classIndex;
    /**
     * 父ID
     */
    private String paraId;
    /**
     * 审核状态
     */
    private Integer auditSign;

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

    public String getPinyYin(){
        return pinyYin;
    }

    public void setPinyYin(String pinyYin){
        this.pinyYin = pinyYin;
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

    public Integer getAuditSign(){
        return auditSign;
    }

    public void setAuditSign(Integer auditSign){
        this.auditSign = auditSign;
    }
}
