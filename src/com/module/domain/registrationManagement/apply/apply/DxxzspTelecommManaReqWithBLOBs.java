package com.module.domain.registrationManagement.apply.apply;

public class DxxzspTelecommManaReqWithBLOBs extends DxxzspTelecommManaReq{
	private String otherMatersFlex;

	public String getOtherMatersFlex() {
        return otherMatersFlex;
    }

    public void setOtherMatersFlex(String otherMatersFlex) {
        this.otherMatersFlex = otherMatersFlex == null ? null : otherMatersFlex.trim();
    }
}
