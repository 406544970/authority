package com.lh.authority.model.InPutParam;

import java.util.Date;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-22 15:24
 * @function
 * @editLog
 */
public class ZoneUpdateInParam {
    /**
     * 主键
     */
    private String id;
    /**
     * 主键, Where字段
     */
    private String idWhere;
    /**
     * 地区名称
     */
    private String label;
    /**
     * 地区名称, Where字段
     */
    private String labelWhere;
    /**
     * 拼音码
     */
    private String pinyYin;
    /**
     * 拼音码, Where字段
     */
    private String pinyYinWhere;
    /**
     * 级别
     */
    private Integer classIndex;
    /**
     * 级别, Where字段
     */
    private Integer classIndexWhere;
    /**
     * 父ID
     */
    private String paraId;
    /**
     * 父ID, Where字段
     */
    private String paraIdWhere;
    /**
     * 审核状态
     */
    private Integer auditSign;
    /**
     * 审核状态, Where字段
     */
    private Integer auditSignWhere;

    public String getId(){
        return id;
    }
    public String getIdWhere(){
        return idWhere;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setIdWhere(String idWhere){
        this.idWhere = idWhere;
    }

    public String getLabel(){
        return label;
    }
    public String getLabelWhere(){
        return labelWhere;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public void setLabelWhere(String labelWhere){
        this.labelWhere = labelWhere;
    }

    public String getPinyYin(){
        return pinyYin;
    }
    public String getPinyYinWhere(){
        return pinyYinWhere;
    }
    public void setPinyYin(String pinyYin){
        this.pinyYin = pinyYin;
    }
    public void setPinyYinWhere(String pinyYinWhere){
        this.pinyYinWhere = pinyYinWhere;
    }

    public Integer getClassIndex(){
        return classIndex;
    }
    public Integer getClassIndexWhere(){
        return classIndexWhere;
    }
    public void setClassIndex(Integer classIndex){
        this.classIndex = classIndex;
    }
    public void setClassIndexWhere(Integer classIndexWhere){
        this.classIndexWhere = classIndexWhere;
    }

    public String getParaId(){
        return paraId;
    }
    public String getParaIdWhere(){
        return paraIdWhere;
    }
    public void setParaId(String paraId){
        this.paraId = paraId;
    }
    public void setParaIdWhere(String paraIdWhere){
        this.paraIdWhere = paraIdWhere;
    }

    public Integer getAuditSign(){
        return auditSign;
    }
    public Integer getAuditSignWhere(){
        return auditSignWhere;
    }
    public void setAuditSign(Integer auditSign){
        this.auditSign = auditSign;
    }
    public void setAuditSignWhere(Integer auditSignWhere){
        this.auditSignWhere = auditSignWhere;
    }

    /**
     * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
     * @create 2019-09-24 12:35
     * @function
     * @editLog
     */
    public static class UseInsertForGet {
        /**
         * 主键
         */
        private String id;
        /**
         * 用户ID
         */
        private String useId;
        /**
         * 无效日期
         */
        private Date endDate;
        /**
         * guid
         */
        private String guid;

        public String getId(){
            return id;
        }

        public void setId(String id){
            this.id = id;
        }

        public String getUseId(){
            return useId;
        }

        public void setUseId(String useId){
            this.useId = useId;
        }

        public Date getEndDate(){
            return endDate;
        }

        public void setEndDate(Date endDate){
            this.endDate = endDate;
        }

        public String getGuid(){
            return guid;
        }

        public void setGuid(String guid){
            this.guid = guid;
        }
    }
}
