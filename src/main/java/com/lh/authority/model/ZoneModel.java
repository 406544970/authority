package com.lh.authority.model;

import java.util.List;

/**
 * @author 姊佹槉
 * @date:2019/9/6
 */
public final class ZoneModel extends ZoneAbstractModel{
    private List<ZoneModelCity> children;

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

    public List<ZoneModelCity> getChildren() {
        return children;
    }

    public void setChildren(List<ZoneModelCity> children) {
        this.children = children;
    }
}
