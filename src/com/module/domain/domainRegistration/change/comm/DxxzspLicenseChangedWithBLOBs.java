package com.module.domain.domainRegistration.change.comm;

public class DxxzspLicenseChangedWithBLOBs extends DxxzspLicenseChanged{
	private String licenseChangedFlex;

    public String getLicenseChangedFlex() {
        return licenseChangedFlex;
    }

    public void setLicenseChangedFlex(String licenseChangedFlex) {
        this.licenseChangedFlex = licenseChangedFlex == null ? null : licenseChangedFlex.trim();
    }
}
