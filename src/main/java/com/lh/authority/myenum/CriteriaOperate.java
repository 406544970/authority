package com.lh.authority.myenum;

public enum CriteriaOperate {
    IS("is","等于"),
    GT("gt","大于"),
    LT("lt","小于"),
    GTE("gte","大于或等于"),
    LTE("lte","小于或等于"),
    NE("ne","不等于"),
    IN("in","IN"),
    NIN("nin","NOT IN"),
    MOD("mod","取模"),
    ALL("all","与IN相似，但必须是集合匹配"),
    LLIKE("llike","左模糊"),
    RLIKE("rlike","右模糊"),
    ALLLIKE("alllike","全模糊");

    private String code;
    private String message;

    private CriteriaOperate(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
