package com.module.domain.domainRegistration.apply.apply;

public class DxxzspOtherMaterialWithBLOBs extends DxxzspOtherMaterial{
	private String otherMaterialFlex;
	
	public String getOtherMaterialFlex() {
        return otherMaterialFlex;
    }

    public void setOtherMaterialFlex(String otherMaterialFlex) {
        this.otherMaterialFlex = otherMaterialFlex == null ? null : otherMaterialFlex.trim();
    }
}
