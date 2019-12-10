package com.module.domain.threeWebElectric.change.change;

public class DxxzspRfcShareholderWithBLOBs extends DxxzspRfcShareholder {
    private String holderInfoS;

    private String equityStructureS;

    private String boardDirectorsS;

    public String getHolderInfoS() {
        return holderInfoS;
    }

    public void setHolderInfoS(String holderInfoS) {
        this.holderInfoS = holderInfoS == null ? null : holderInfoS.trim();
    }

    public String getEquityStructureS() {
        return equityStructureS;
    }

    public void setEquityStructureS(String equityStructureS) {
        this.equityStructureS = equityStructureS == null ? null : equityStructureS.trim();
    }

    public String getBoardDirectorsS() {
        return boardDirectorsS;
    }

    public void setBoardDirectorsS(String boardDirectorsS) {
        this.boardDirectorsS = boardDirectorsS == null ? null : boardDirectorsS.trim();
    }
}