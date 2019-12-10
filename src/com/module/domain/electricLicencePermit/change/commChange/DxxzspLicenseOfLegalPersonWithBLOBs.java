package com.module.domain.electricLicencePermit.change.commChange;

public class DxxzspLicenseOfLegalPersonWithBLOBs extends DxxzspLicenseOfLegalPerson {
	private String deptFlex;

    public String getDeptFlex() {
        return deptFlex;
    }

    public void setDeptFlex(String deptFlex) {
        this.deptFlex = deptFlex == null ? null : deptFlex.trim();
    }
}