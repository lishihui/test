package com.module.domain.threeWebElectric.change.change;

public class DxxzspRfcComnameWithBLOBs extends DxxzspRfcComname {
    private String proveD;

    private String commitimentD;

    public String getProveD() {
        return proveD;
    }

    public void setProveD(String proveD) {
        this.proveD = proveD == null ? null : proveD.trim();
    }

    public String getCommitimentD() {
        return commitimentD;
    }

    public void setCommitimentD(String commitimentD) {
        this.commitimentD = commitimentD == null ? null : commitimentD.trim();
    }
}