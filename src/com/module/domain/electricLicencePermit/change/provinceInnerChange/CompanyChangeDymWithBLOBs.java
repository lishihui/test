package com.module.domain.electricLicencePermit.change.provinceInnerChange;

public class CompanyChangeDymWithBLOBs extends DxxzspCompanyChangeDym {
    private String authBusiness;

    private String listedCoFlex;

    private String noListedFlex;

    private String authsubFlex;

    private String noForeginApprflex;

    private String gdzsFlex;

    public String getAuthBusiness() {
        return authBusiness;
    }

    public void setAuthBusiness(String authBusiness) {
        this.authBusiness = authBusiness == null ? null : authBusiness.trim();
    }

    public String getListedCoFlex() {
        return listedCoFlex;
    }

    public void setListedCoFlex(String listedCoFlex) {
        this.listedCoFlex = listedCoFlex == null ? null : listedCoFlex.trim();
    }

    public String getNoListedFlex() {
        return noListedFlex;
    }

    public void setNoListedFlex(String noListedFlex) {
        this.noListedFlex = noListedFlex == null ? null : noListedFlex.trim();
    }

    public String getAuthsubFlex() {
        return authsubFlex;
    }

    public void setAuthsubFlex(String authsubFlex) {
        this.authsubFlex = authsubFlex == null ? null : authsubFlex.trim();
    }

    public String getNoForeginApprflex() {
        return noForeginApprflex;
    }

    public void setNoForeginApprflex(String noForeginApprflex) {
        this.noForeginApprflex = noForeginApprflex == null ? null : noForeginApprflex.trim();
    }

    public String getGdzsFlex() {
        return gdzsFlex;
    }

    public void setGdzsFlex(String gdzsFlex) {
        this.gdzsFlex = gdzsFlex == null ? null : gdzsFlex.trim();
    }
}