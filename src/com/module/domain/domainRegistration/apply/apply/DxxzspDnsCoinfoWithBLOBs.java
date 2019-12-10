package com.module.domain.domainRegistration.apply.apply;

public class DxxzspDnsCoinfoWithBLOBs extends DxxzspDnsCoinfo {
    private String companyDetail;

    private String businessType;

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail == null ? null : companyDetail.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}