package com.module.domain.threeWebElectric.change.change;

public class DxxzspRfcRenewalWithBLOBs extends DxxzspRfcRenewal {
    private String coopAggreH;

    private String holderResulrH;

    private String commitLetterH;

    public String getCoopAggreH() {
        return coopAggreH;
    }

    public void setCoopAggreH(String coopAggreH) {
        this.coopAggreH = coopAggreH == null ? null : coopAggreH.trim();
    }

    public String getHolderResulrH() {
        return holderResulrH;
    }

    public void setHolderResulrH(String holderResulrH) {
        this.holderResulrH = holderResulrH == null ? null : holderResulrH.trim();
    }

    public String getCommitLetterH() {
        return commitLetterH;
    }

    public void setCommitLetterH(String commitLetterH) {
        this.commitLetterH = commitLetterH == null ? null : commitLetterH.trim();
    }
}
