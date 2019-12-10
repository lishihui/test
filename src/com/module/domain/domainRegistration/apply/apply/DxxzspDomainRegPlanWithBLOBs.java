package com.module.domain.domainRegistration.apply.apply;

public class DxxzspDomainRegPlanWithBLOBs extends DxxzspDomainRegPlan{
	private String implDetailsFlex;
	
	public String getImplDetailsFlex() {
        return implDetailsFlex;
    }

    public void setImplDetailsFlex(String implDetailsFlex) {
        this.implDetailsFlex = implDetailsFlex == null ? null : implDetailsFlex.trim();
    }
}
