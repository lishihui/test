package com.module.domain.domainRegistration.apply.apply;

public class DxxzspImplSchemeWithBLOBs extends DxxzspImplScheme {
    private String managerFlowFlex;

    private String userComplaintsHandling;

    private String techSolutionsFlex;

    private String analyzeServerStatus;

    private String domainSupervisionFlex;

    public String getManagerFlowFlex() {
        return managerFlowFlex;
    }

    public void setManagerFlowFlex(String managerFlowFlex) {
        this.managerFlowFlex = managerFlowFlex == null ? null : managerFlowFlex.trim();
    }

    public String getUserComplaintsHandling() {
        return userComplaintsHandling;
    }

    public void setUserComplaintsHandling(String userComplaintsHandling) {
        this.userComplaintsHandling = userComplaintsHandling == null ? null : userComplaintsHandling.trim();
    }

    public String getTechSolutionsFlex() {
        return techSolutionsFlex;
    }

    public void setTechSolutionsFlex(String techSolutionsFlex) {
        this.techSolutionsFlex = techSolutionsFlex == null ? null : techSolutionsFlex.trim();
    }

    public String getAnalyzeServerStatus() {
        return analyzeServerStatus;
    }

    public void setAnalyzeServerStatus(String analyzeServerStatus) {
        this.analyzeServerStatus = analyzeServerStatus == null ? null : analyzeServerStatus.trim();
    }

    public String getDomainSupervisionFlex() {
        return domainSupervisionFlex;
    }

    public void setDomainSupervisionFlex(String domainSupervisionFlex) {
        this.domainSupervisionFlex = domainSupervisionFlex == null ? null : domainSupervisionFlex.trim();
    }
}