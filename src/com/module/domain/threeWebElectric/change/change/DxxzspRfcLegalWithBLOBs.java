package com.module.domain.threeWebElectric.change.change;

public class DxxzspRfcLegalWithBLOBs extends DxxzspRfcLegal {
    private String newIdcardImageF;

    private String commitimentF;

    private String oldCardimg;

    private String newCardimg;

    public String getNewIdcardImageF() {
        return newIdcardImageF;
    }

    public void setNewIdcardImageF(String newIdcardImageF) {
        this.newIdcardImageF = newIdcardImageF == null ? null : newIdcardImageF.trim();
    }

    public String getCommitimentF() {
        return commitimentF;
    }

    public void setCommitimentF(String commitimentF) {
        this.commitimentF = commitimentF == null ? null : commitimentF.trim();
    }

    public String getOldCardimg() {
        return oldCardimg;
    }

    public void setOldCardimg(String oldCardimg) {
        this.oldCardimg = oldCardimg == null ? null : oldCardimg.trim();
    }

    public String getNewCardimg() {
        return newCardimg;
    }

    public void setNewCardimg(String newCardimg) {
        this.newCardimg = newCardimg == null ? null : newCardimg.trim();
    }
}