package com.module.domain.electricLicencePermit.change.provinceInnerChange;

public class DynamicTableWithBLOBs extends DynamicTable{
	private String businessFlex;

    public String getBusinessFlex() {
        return businessFlex;
    }

    public void setBusinessFlex(String businessFlex) {
        this.businessFlex = businessFlex == null ? null : businessFlex.trim();
    }

}
