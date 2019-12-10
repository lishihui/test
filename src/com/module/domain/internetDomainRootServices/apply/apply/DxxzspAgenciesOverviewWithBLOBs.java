package com.module.domain.internetDomainRootServices.apply.apply;

public class DxxzspAgenciesOverviewWithBLOBs extends DxxzspAgenciesOverview {
    private String mainBusiness;

    private String mainUser;

    private String linkFlex;

    private String headFlex;

    private String legalFlex;

    private String socialSecurityFlex;

    private String employeeContractFlex;

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
    }

    public String getMainUser() {
        return mainUser;
    }

    public void setMainUser(String mainUser) {
        this.mainUser = mainUser == null ? null : mainUser.trim();
    }

    public String getLinkFlex() {
        return linkFlex;
    }

    public void setLinkFlex(String linkFlex) {
        this.linkFlex = linkFlex == null ? null : linkFlex.trim();
    }

    public String getHeadFlex() {
        return headFlex;
    }

    public void setHeadFlex(String headFlex) {
        this.headFlex = headFlex == null ? null : headFlex.trim();
    }

    public String getLegalFlex() {
        return legalFlex;
    }

    public void setLegalFlex(String legalFlex) {
        this.legalFlex = legalFlex == null ? null : legalFlex.trim();
    }

    public String getSocialSecurityFlex() {
        return socialSecurityFlex;
    }

    public void setSocialSecurityFlex(String socialSecurityFlex) {
        this.socialSecurityFlex = socialSecurityFlex == null ? null : socialSecurityFlex.trim();
    }

    public String getEmployeeContractFlex() {
        return employeeContractFlex;
    }

    public void setEmployeeContractFlex(String employeeContractFlex) {
        this.employeeContractFlex = employeeContractFlex == null ? null : employeeContractFlex.trim();
    }
}