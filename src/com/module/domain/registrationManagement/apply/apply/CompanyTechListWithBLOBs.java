package com.module.domain.registrationManagement.apply.apply;

public class CompanyTechListWithBLOBs extends CompanyTechList {
	 private String techIdFlex1;
	 public String getTechIdFlex1() {
	        return techIdFlex1;
	    }

	    public void setTechIdFlex1(String techIdFlex1) {
	        this.techIdFlex1 = techIdFlex1 == null ? null : techIdFlex1.trim();
	    }
}