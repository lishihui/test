package com.module.domain.ftaTradeApplication.change.comm;

public class ZmqcChangePublicFormsWithBLOBs extends ZmqcChangePublicForms{
	private String deptFlex;
	
	public String getDeptFlex() {
        return deptFlex;
    }

    public void setDeptFlex(String deptFlex) {
        this.deptFlex = deptFlex == null ? null : deptFlex.trim();
    }
}
