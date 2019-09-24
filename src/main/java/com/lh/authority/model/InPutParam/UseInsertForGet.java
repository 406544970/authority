package com.lh.authority.model.InPutParam;

import java.util.Date;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-24 12:35
 * @function
 * @editLog
 */
public class UseInsertForGet {
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
