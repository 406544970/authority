package com.lh.authority.model;

/**
 * @author 姊佹槉
 * @date:2019/9/6
 */
public abstract class ZoneAbstractModel {
    private String value;
    private String label;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
