package com.module.domain.registrationManagement.apply.apply;

public class DxxzspLegalIntegrityWithBLOBs extends DxxzspLegalIntegrity {
	private String dnsPromiseFlex;

    public String getDnsPromiseFlex() {
        return dnsPromiseFlex;
    }

    public void setDnsPromiseFlex(String dnsPromiseFlex) {
        this.dnsPromiseFlex = dnsPromiseFlex == null ? null : dnsPromiseFlex.trim();
    }
}