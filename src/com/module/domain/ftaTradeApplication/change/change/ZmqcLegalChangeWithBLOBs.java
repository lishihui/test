package com.module.domain.ftaTradeApplication.change.change;

public class ZmqcLegalChangeWithBLOBs extends ZmqcLegalChange{
	private String legalPromiseFlex;
	
	public String getLegalPromiseFlex() {
        return legalPromiseFlex;
    }

    public void setLegalPromiseFlex(String legalPromiseFlex) {
        this.legalPromiseFlex = legalPromiseFlex == null ? null : legalPromiseFlex.trim();
    }
}
