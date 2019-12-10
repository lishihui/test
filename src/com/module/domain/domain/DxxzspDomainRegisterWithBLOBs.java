package com.module.domain.domain;

public class DxxzspDomainRegisterWithBLOBs extends DxxzspDomainRegister {
    private String businessType;

    private String sharedholderFlex;

    private String licenseFlex;

    private String businessLicenseFlex;

    private String officeContractFlex;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getSharedholderFlex() {
        return sharedholderFlex;
    }

    public void setSharedholderFlex(String sharedholderFlex) {
        this.sharedholderFlex = sharedholderFlex == null ? null : sharedholderFlex.trim();
    }

    public String getLicenseFlex() {
        return licenseFlex;
    }

    public void setLicenseFlex(String licenseFlex) {
        this.licenseFlex = licenseFlex == null ? null : licenseFlex.trim();
    }

    public String getBusinessLicenseFlex() {
        return businessLicenseFlex;
    }

    public void setBusinessLicenseFlex(String businessLicenseFlex) {
        this.businessLicenseFlex = businessLicenseFlex == null ? null : businessLicenseFlex.trim();
    }

    public String getOfficeContractFlex() {
        return officeContractFlex;
    }

    public void setOfficeContractFlex(String officeContractFlex) {
        this.officeContractFlex = officeContractFlex == null ? null : officeContractFlex.trim();
    }
}