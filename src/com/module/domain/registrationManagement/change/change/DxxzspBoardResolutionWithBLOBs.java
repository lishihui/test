package com.module.domain.registrationManagement.change.change;

public class DxxzspBoardResolutionWithBLOBs extends DxxzspBoardResolution{
	private String resolutionFlex;

	public String getResolutionFlex() {
		return resolutionFlex;
	}

	public void setResolutionFlex(String resolutionFlex) {
		this.resolutionFlex = resolutionFlex == null ? null
				: resolutionFlex.trim();
	}
}
