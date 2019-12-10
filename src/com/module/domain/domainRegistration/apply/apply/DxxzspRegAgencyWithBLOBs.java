package com.module.domain.domainRegistration.apply.apply;

public class DxxzspRegAgencyWithBLOBs extends DxxzspRegAgency{
	private String manaSupervisionFlex;
	
	public String getManaSupervisionFlex() {
        return manaSupervisionFlex;
    }

    public void setManaSupervisionFlex(String manaSupervisionFlex) {
        this.manaSupervisionFlex = manaSupervisionFlex == null ? null : manaSupervisionFlex.trim();
    }
}
