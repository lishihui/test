package com.module.domain.domainRegistration.apply.apply;

public class DxxzspRegisterServerLsWithBLOBs extends DxxzspRegisterServerLs{
	private String registrServerZong;
	
	public String getRegistrServerZong() {
        return registrServerZong;
    }

    public void setRegistrServerZong(String registrServerZong) {
        this.registrServerZong = registrServerZong == null ? null : registrServerZong.trim();
    }
}
