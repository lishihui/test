package com.module.domain.ftaTradeApplication.change.change;

public class ZmqcAuthorizedCompany {
    private String id;

    private String title;

    private String created;

    private String modified;

    private String creator;

    private String modificator;

    private String recycle;

    private String coName;

    private String licenseNo;

    private String coDetail;

    private String noForeginInvest;

    private String contForeignInvest;

    private String conInvsetNotAccess;

    private String coType;

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

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName == null ? null : coName.trim();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public String getCoDetail() {
        return coDetail;
    }

    public void setCoDetail(String coDetail) {
        this.coDetail = coDetail == null ? null : coDetail.trim();
    }

    public String getNoForeginInvest() {
        return noForeginInvest;
    }

    public void setNoForeginInvest(String noForeginInvest) {
        this.noForeginInvest = noForeginInvest == null ? null : noForeginInvest.trim();
    }

    public String getContForeignInvest() {
        return contForeignInvest;
    }

    public void setContForeignInvest(String contForeignInvest) {
        this.contForeignInvest = contForeignInvest == null ? null : contForeignInvest.trim();
    }

    public String getConInvsetNotAccess() {
        return conInvsetNotAccess;
    }

    public void setConInvsetNotAccess(String conInvsetNotAccess) {
        this.conInvsetNotAccess = conInvsetNotAccess == null ? null : conInvsetNotAccess.trim();
    }

    public String getCoType() {
        return coType;
    }

    public void setCoType(String coType) {
        this.coType = coType == null ? null : coType.trim();
    }
}