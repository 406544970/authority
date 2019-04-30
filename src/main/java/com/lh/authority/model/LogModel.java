package com.lh.authority.model;

/**
 * @author 梁昊
 * @date 2019/4/30
 * @function
 * @editLog
 */
public class LogModel {
    public LogModel() {
        super();
        this.useType = "BS";
        this.timeOut = 24;
    }

    private String useId;
    private String useType;
    private String accessToken;

    public Integer getTimeOut() {
        return timeOut;
    }

    /**
     * 超时时间：秒，默认值：3600秒
     */
    private Integer timeOut;

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
