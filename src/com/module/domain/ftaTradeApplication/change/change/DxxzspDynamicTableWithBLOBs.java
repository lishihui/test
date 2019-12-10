package com.module.domain.ftaTradeApplication.change.change;

public class DxxzspDynamicTableWithBLOBs extends DxxzspDynamicTable {
	private String businessFlex;

	public String getBusinessFlex() {
		return businessFlex;
	}

	public void setBusinessFlex(String businessFlex) {
		this.businessFlex = businessFlex == null ? null : businessFlex.trim();
	}
}
