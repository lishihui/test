package com.module.domain.ftaTradeApplication.change.change;

public class ZmqcContinueApplicationWithBLOBs extends ZmqcContinueApplication {
    private String continueType;

    private String noRunBusi;

    public String getContinueType() {
        return continueType;
    }

    public void setContinueType(String continueType) {
        this.continueType = continueType == null ? null : continueType.trim();
    }

    public String getNoRunBusi() {
        return noRunBusi;
    }

    public void setNoRunBusi(String noRunBusi) {
        this.noRunBusi = noRunBusi == null ? null : noRunBusi.trim();
    }
}