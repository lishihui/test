package com.module.domain.electricLicencePermit.change.provinceInnerChange;

public class DxxzspReplenishmentOfLostWithBLOBs extends DxxzspReplenishmentOfLost {
    private String lossLicenseDecla;

    
    public String getLossLicenseDecla() {
        return lossLicenseDecla;
    }

    public void setLossLicenseDecla(String LossLicenseDecla) {
        this.lossLicenseDecla = lossLicenseDecla == null ? null : lossLicenseDecla.trim();
    }

   
}