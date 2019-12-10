package com.module.domain.domain;

public class FormMetaWithBLOBs extends FormMeta {
    private String expand;

    private String ganged;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand == null ? null : expand.trim();
    }

    public String getGanged() {
        return ganged;
    }

    public void setGanged(String ganged) {
        this.ganged = ganged == null ? null : ganged.trim();
    }
}