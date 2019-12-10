package com.module.domain.ftaTradeApplication.change.change;

public class ZmqcAuthorizedCompanyWithBLOBs extends ZmqcAuthorizedCompany {
    private String authPromiseFlex;

    private String notForeignFlex;

    private String coApprove;

    private String infoPulblicFlex;

    public String getAuthPromiseFlex() {
        return authPromiseFlex;
    }

    public void setAuthPromiseFlex(String authPromiseFlex) {
        this.authPromiseFlex = authPromiseFlex == null ? null : authPromiseFlex.trim();
    }

    public String getNotForeignFlex() {
        return notForeignFlex;
    }

    public void setNotForeignFlex(String notForeignFlex) {
        this.notForeignFlex = notForeignFlex == null ? null : notForeignFlex.trim();
    }

    public String getCoApprove() {
        return coApprove;
    }

    public void setCoApprove(String coApprove) {
        this.coApprove = coApprove == null ? null : coApprove.trim();
    }

    public String getInfoPulblicFlex() {
        return infoPulblicFlex;
    }

    public void setInfoPulblicFlex(String infoPulblicFlex) {
        this.infoPulblicFlex = infoPulblicFlex == null ? null : infoPulblicFlex.trim();
    }
}