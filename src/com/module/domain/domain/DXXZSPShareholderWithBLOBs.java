package com.module.domain.domain;

public class DXXZSPShareholderWithBLOBs extends DXXZSPShareholder {
    private String proof;

    private String gdzscns;

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof == null ? null : proof.trim();
    }

    public String getGdzscns() {
        return gdzscns;
    }

    public void setGdzscns(String gdzscns) {
        this.gdzscns = gdzscns == null ? null : gdzscns.trim();
    }
}