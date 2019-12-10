package com.module.domain.domainRegistration.apply.apply;

public class DxxzspCheckSystemListWithBLOBs extends DxxzspCheckSystemList {
	private String checkSystemZong;

	public String getCheckSystemZong() {
		return checkSystemZong;
	}

	public void setCheckSystemZong(String checkSystemZong) {
		this.checkSystemZong = checkSystemZong == null ? null : checkSystemZong.trim();
	}
}
