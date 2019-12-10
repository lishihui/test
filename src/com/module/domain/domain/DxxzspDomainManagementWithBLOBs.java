package com.module.domain.domain;

public class DxxzspDomainManagementWithBLOBs extends DxxzspDomainManagement {
    private String devDomainSystem;

    private String registerMechanism;

    private String domainRegFlex1;

    private String complaintResponseFlow;

    private String handlingComplaints;

    private String complaintContactMethod;

    private String inspectionViolation;

    private String illegalDomainList;

    private String illegalDomainManager;

    private String techIllegalDomain;

    private String reportIllegalDomain;

    public String getDevDomainSystem() {
        return devDomainSystem;
    }

    public void setDevDomainSystem(String devDomainSystem) {
        this.devDomainSystem = devDomainSystem == null ? null : devDomainSystem.trim();
    }

    public String getRegisterMechanism() {
        return registerMechanism;
    }

    public void setRegisterMechanism(String registerMechanism) {
        this.registerMechanism = registerMechanism == null ? null : registerMechanism.trim();
    }

    public String getDomainRegFlex1() {
        return domainRegFlex1;
    }

    public void setDomainRegFlex1(String domainRegFlex1) {
        this.domainRegFlex1 = domainRegFlex1 == null ? null : domainRegFlex1.trim();
    }

    public String getComplaintResponseFlow() {
        return complaintResponseFlow;
    }

    public void setComplaintResponseFlow(String complaintResponseFlow) {
        this.complaintResponseFlow = complaintResponseFlow == null ? null : complaintResponseFlow.trim();
    }

    public String getHandlingComplaints() {
        return handlingComplaints;
    }

    public void setHandlingComplaints(String handlingComplaints) {
        this.handlingComplaints = handlingComplaints == null ? null : handlingComplaints.trim();
    }

    public String getComplaintContactMethod() {
        return complaintContactMethod;
    }

    public void setComplaintContactMethod(String complaintContactMethod) {
        this.complaintContactMethod = complaintContactMethod == null ? null : complaintContactMethod.trim();
    }

    public String getInspectionViolation() {
        return inspectionViolation;
    }

    public void setInspectionViolation(String inspectionViolation) {
        this.inspectionViolation = inspectionViolation == null ? null : inspectionViolation.trim();
    }

    public String getIllegalDomainList() {
        return illegalDomainList;
    }

    public void setIllegalDomainList(String illegalDomainList) {
        this.illegalDomainList = illegalDomainList == null ? null : illegalDomainList.trim();
    }

    public String getIllegalDomainManager() {
        return illegalDomainManager;
    }

    public void setIllegalDomainManager(String illegalDomainManager) {
        this.illegalDomainManager = illegalDomainManager == null ? null : illegalDomainManager.trim();
    }

    public String getTechIllegalDomain() {
        return techIllegalDomain;
    }

    public void setTechIllegalDomain(String techIllegalDomain) {
        this.techIllegalDomain = techIllegalDomain == null ? null : techIllegalDomain.trim();
    }

    public String getReportIllegalDomain() {
        return reportIllegalDomain;
    }

    public void setReportIllegalDomain(String reportIllegalDomain) {
        this.reportIllegalDomain = reportIllegalDomain == null ? null : reportIllegalDomain.trim();
    }
}