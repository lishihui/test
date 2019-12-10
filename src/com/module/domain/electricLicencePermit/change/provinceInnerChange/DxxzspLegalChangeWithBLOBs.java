package com.module.domain.electricLicencePermit.change.provinceInnerChange;

public class DxxzspLegalChangeWithBLOBs extends DxxzspLegalChange {
	private String legalPromiseFlex;

    
    public String getLegalPromiseFlex() {
        return legalPromiseFlex;
    }

    public void setLegalPromiseFlex(String legalPromiseFlex) {
        this.legalPromiseFlex = legalPromiseFlex == null ? null : legalPromiseFlex.trim();
    }
   
}