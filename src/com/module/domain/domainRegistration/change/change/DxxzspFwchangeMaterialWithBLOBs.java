package com.module.domain.domainRegistration.change.change;

public class DxxzspFwchangeMaterialWithBLOBs extends DxxzspFwchangeMaterial{
	private String otherMaterialsFlex;
	
	public String getOtherMaterialsFlex() {
        return otherMaterialsFlex;
    }

    public void setOtherMaterialsFlex(String otherMaterialsFlex) {
        this.otherMaterialsFlex = otherMaterialsFlex == null ? null : otherMaterialsFlex.trim();
    }
}
