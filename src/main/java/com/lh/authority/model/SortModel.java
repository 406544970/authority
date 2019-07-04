package com.lh.authority.model;

public class SortModel {
    private Boolean ascSign;
    private String fieldName;

    public Boolean getAscSign() {
        return ascSign;
    }

    public void setAscSign(Boolean ascSign) {
        this.ascSign = ascSign;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public SortModel() {
        super();
        this.ascSign = true;
    }
}
