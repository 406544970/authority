package com.lh.authority.model;

import java.util.List;

/**
 * @author 姊佹槉
 * @date:2019/9/6
 */
public class ZoneModelArea extends ZoneAbstractModel {
    private List<ZoneModelStreet> children;
    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

    public List<ZoneModelStreet> getChildren() {
        return children;
    }

    public void setChildren(List<ZoneModelStreet> children) {
        this.children = children;
    }
}
