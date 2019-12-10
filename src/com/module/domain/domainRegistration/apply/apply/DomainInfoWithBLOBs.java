package com.module.domain.domainRegistration.apply.apply;

public class DomainInfoWithBLOBs extends DomainInfo{
	private String agencyContract;
	
	public String getAgencyContract() {
        return agencyContract;
    }

    public void setAgencyContract(String agencyContract) {
        this.agencyContract = agencyContract == null ? null : agencyContract.trim();
    }
}
