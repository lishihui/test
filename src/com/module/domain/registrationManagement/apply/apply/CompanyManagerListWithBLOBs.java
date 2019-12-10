package com.module.domain.registrationManagement.apply.apply;

public class CompanyManagerListWithBLOBs extends CompanyManagerList {
	private String managerIdFlex;

	public String getManagerIdFlex() {
        return managerIdFlex;
    }

    public void setManagerIdFlex(String managerIdFlex) {
        this.managerIdFlex = managerIdFlex == null ? null : managerIdFlex.trim();
    }
}