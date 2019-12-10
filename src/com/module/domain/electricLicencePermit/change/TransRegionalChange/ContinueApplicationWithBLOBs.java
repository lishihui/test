package com.module.domain.electricLicencePermit.change.TransRegionalChange;

public class ContinueApplicationWithBLOBs extends ContinueApplication {
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