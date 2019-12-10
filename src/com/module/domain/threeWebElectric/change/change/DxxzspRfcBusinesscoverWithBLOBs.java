package com.module.domain.threeWebElectric.change.change;

public class DxxzspRfcBusinesscoverWithBLOBs extends DxxzspBusinessCoverageChange {
    private String commitLetterC;

    private String boardDirectorsC;

    public String getCommitLetterC() {
        return commitLetterC;
    }

    public void setCommitLetterC(String commitLetterC) {
        this.commitLetterC = commitLetterC == null ? null : commitLetterC.trim();
    }

    public String getBoardDirectorsC() {
        return boardDirectorsC;
    }

    public void setBoardDirectorsC(String boardDirectorsC) {
        this.boardDirectorsC = boardDirectorsC == null ? null : boardDirectorsC.trim();
    }
}