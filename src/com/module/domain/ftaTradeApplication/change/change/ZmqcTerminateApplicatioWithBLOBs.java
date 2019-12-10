package com.module.domain.ftaTradeApplication.change.change;

public class ZmqcTerminateApplicatioWithBLOBs extends ZmqcTerminateApplicatio {
    private String terBusiType;

    private String contBusiType;

    private String remarks;

    private String userProcessScheme;

    private String socialPublicity;

    private String userAdvise;

    private String implementationPlan;

    private String cpDetailFlex;

    public String getTerBusiType() {
        return terBusiType;
    }

    public void setTerBusiType(String terBusiType) {
        this.terBusiType = terBusiType == null ? null : terBusiType.trim();
    }

    public String getContBusiType() {
        return contBusiType;
    }

    public void setContBusiType(String contBusiType) {
        this.contBusiType = contBusiType == null ? null : contBusiType.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getUserProcessScheme() {
        return userProcessScheme;
    }

    public void setUserProcessScheme(String userProcessScheme) {
        this.userProcessScheme = userProcessScheme == null ? null : userProcessScheme.trim();
    }

    public String getSocialPublicity() {
        return socialPublicity;
    }

    public void setSocialPublicity(String socialPublicity) {
        this.socialPublicity = socialPublicity == null ? null : socialPublicity.trim();
    }

    public String getUserAdvise() {
        return userAdvise;
    }

    public void setUserAdvise(String userAdvise) {
        this.userAdvise = userAdvise == null ? null : userAdvise.trim();
    }

    public String getImplementationPlan() {
        return implementationPlan;
    }

    public void setImplementationPlan(String implementationPlan) {
        this.implementationPlan = implementationPlan == null ? null : implementationPlan.trim();
    }

    public String getCpDetailFlex() {
        return cpDetailFlex;
    }

    public void setCpDetailFlex(String cpDetailFlex) {
        this.cpDetailFlex = cpDetailFlex == null ? null : cpDetailFlex.trim();
    }
}