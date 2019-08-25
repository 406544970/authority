package com.lh.authority.model.InPutParam;

/**
 * @author ：梁昊，后端工程师：杨凯，前端工程师：陈盼
 * @create 2019-08-11 00:31
 * @function
 * @editLog
 */
public class UserInPutPara  {
    /**
     * 表user,原字段名id,现字段名mainId:主键
     */
    private String mainId;
    /**
     * 表user,原字段名id,现字段名sub2Id:主键
     */
    private String sub2Id;

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public String getSub2Id() {
        return sub2Id;
    }

    public void setSub2Id(String sub2Id) {
        this.sub2Id = sub2Id;
    }
}
