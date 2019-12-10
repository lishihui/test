package com.module.domain.domain;

public class DxxzspDomainCompanyWithBLOBs extends DxxzspDomainCompany {
    private String mainBusiness;

    private String mainUserGroups;

    private String linkIdFlex1;

    private String responsibleIdFlex;

    private String legalIdFlex1;

    private String socialSecurityProvFlex;

    private String empLaborContractFlex;

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
    }

    public String getMainUserGroups() {
        return mainUserGroups;
    }

    public void setMainUserGroups(String mainUserGroups) {
        this.mainUserGroups = mainUserGroups == null ? null : mainUserGroups.trim();
    }

    public String getLinkIdFlex1() {
        return linkIdFlex1;
    }

    public void setLinkIdFlex1(String linkIdFlex1) {
        this.linkIdFlex1 = linkIdFlex1 == null ? null : linkIdFlex1.trim();
    }

    public String getResponsibleIdFlex() {
        return responsibleIdFlex;
    }

    public void setResponsibleIdFlex(String responsibleIdFlex) {
        this.responsibleIdFlex = responsibleIdFlex == null ? null : responsibleIdFlex.trim();
    }

    public String getLegalIdFlex1() {
        return legalIdFlex1;
    }

    public void setLegalIdFlex1(String legalIdFlex1) {
        this.legalIdFlex1 = legalIdFlex1 == null ? null : legalIdFlex1.trim();
    }

    public String getSocialSecurityProvFlex() {
        return socialSecurityProvFlex;
    }

    public void setSocialSecurityProvFlex(String socialSecurityProvFlex) {
        this.socialSecurityProvFlex = socialSecurityProvFlex == null ? null : socialSecurityProvFlex.trim();
    }

    public String getEmpLaborContractFlex() {
        return empLaborContractFlex;
    }

    public void setEmpLaborContractFlex(String empLaborContractFlex) {
        this.empLaborContractFlex = empLaborContractFlex == null ? null : empLaborContractFlex.trim();
    }
}