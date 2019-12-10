package com.module.domain.electricLicencePermit.change.TransRegionalChange;

public class CompanyConversion {
    private String id;

    private String title;

    private String created;

    private String modified;

    private String creator;

    private String modificator;

    private String recycle;

    private String companyName;

    private String licenseNumber;

    private String changedCompanyName;

    private String nameChangeProof;

    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified == null ? null : modified.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModificator() {
        return modificator;
    }

    public void setModificator(String modificator) {
        this.modificator = modificator == null ? null : modificator.trim();
    }

    public String getRecycle() {
        return recycle;
    }

    public void setRecycle(String recycle) {
        this.recycle = recycle == null ? null : recycle.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    public String getChangedCompanyName() {
        return changedCompanyName;
    }

    public void setChangedCompanyName(String changedCompanyName) {
        this.changedCompanyName = changedCompanyName == null ? null : changedCompanyName.trim();
    }

    public String getNameChangeProof() {
        return nameChangeProof;
    }

    public void setNameChangeProof(String nameChangeProof) {
        this.nameChangeProof = nameChangeProof == null ? null : nameChangeProof.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}