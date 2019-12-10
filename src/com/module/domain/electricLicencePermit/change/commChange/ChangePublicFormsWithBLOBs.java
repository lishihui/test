package com.module.domain.electricLicencePermit.change.commChange;

public class ChangePublicFormsWithBLOBs extends ChangePublicForms{
	private String deptFlex;
	
	public String getDeptFlex() {
        return deptFlex;
    }

    public void setDeptFlex(String deptFlex) {
        this.deptFlex = deptFlex == null ? null : deptFlex.trim();
    }
}
