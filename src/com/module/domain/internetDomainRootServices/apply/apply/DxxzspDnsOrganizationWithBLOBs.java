package com.module.domain.internetDomainRootServices.apply.apply;

public class DxxzspDnsOrganizationWithBLOBs extends DxxzspDnsOrganization {
    private String sharedholderFlex;

    private String businessType;

    private String licenseFlex;

    private String busiLicenseFlex;

    private String leaseContractFlex;

    public String getSharedholderFlex() {
        return sharedholderFlex;
    }

    public void setSharedholderFlex(String sharedholderFlex) {
        this.sharedholderFlex = sharedholderFlex == null ? null : sharedholderFlex.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getLicenseFlex() {
        return licenseFlex;
    }

    public void setLicenseFlex(String licenseFlex) {
        this.licenseFlex = licenseFlex == null ? null : licenseFlex.trim();
    }

    public String getBusiLicenseFlex() {
        return busiLicenseFlex;
    }

    public void setBusiLicenseFlex(String busiLicenseFlex) {
        this.busiLicenseFlex = busiLicenseFlex == null ? null : busiLicenseFlex.trim();
    }

    public String getLeaseContractFlex() {
        return leaseContractFlex;
    }

    public void setLeaseContractFlex(String leaseContractFlex) {
        this.leaseContractFlex = leaseContractFlex == null ? null : leaseContractFlex.trim();
    }
}