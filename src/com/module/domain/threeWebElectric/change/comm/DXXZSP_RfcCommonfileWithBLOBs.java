package com.module.domain.threeWebElectric.change.comm;

public class DXXZSP_RfcCommonfileWithBLOBs extends DXXZSP_RfcCommonfile {
    private String businessLicenceI;

    private String respondedI;

    private String otherFiles;

    public String getBusinessLicenceI() {
        return businessLicenceI;
    }

    public void setBusinessLicenceI(String businessLicenceI) {
        this.businessLicenceI = businessLicenceI == null ? null : businessLicenceI.trim();
    }

    public String getRespondedI() {
        return respondedI;
    }

    public void setRespondedI(String respondedI) {
        this.respondedI = respondedI == null ? null : respondedI.trim();
    }

    public String getOtherFiles() {
        return otherFiles;
    }

    public void setOtherFiles(String otherFiles) {
        this.otherFiles = otherFiles == null ? null : otherFiles.trim();
    }
}