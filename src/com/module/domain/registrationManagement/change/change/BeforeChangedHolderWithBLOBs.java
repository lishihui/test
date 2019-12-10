package com.module.domain.registrationManagement.change.change;

public class BeforeChangedHolderWithBLOBs extends BeforeChangedHolder{
	private String sharedholderIdFlex;
	
	public String getSharedholderIdFlex() {
        return sharedholderIdFlex;
    }

    public void setSharedholderIdFlex(String sharedholderIdFlex) {
        this.sharedholderIdFlex = sharedholderIdFlex == null ? null : sharedholderIdFlex.trim();
    }
}
