package com.module.domain.domainRegistration.change.change;

public class DxxzspAgencyLicenseWithBLOBs extends DxxzspAgencyLicense{
	private String licenseFlex1;

    public String getLicenseFlex1() {
        return licenseFlex1;
    }

    public void setLicenseFlex1(String licenseFlex1) {
        this.licenseFlex1 = licenseFlex1 == null ? null : licenseFlex1.trim();
    }
}
