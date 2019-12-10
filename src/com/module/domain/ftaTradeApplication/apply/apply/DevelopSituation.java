package com.module.domain.ftaTradeApplication.apply.apply;

public class DevelopSituation {
	private String id;

    private String title;

    private String created;

    private String modified;

    private String creator;

    private String modificator;

    private String recycle;

    private String developApplication;

    private String realizeManner;

    private String otherManner;

    private String serviceDescription;

    private String parentid;

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

    public String getDevelopApplication() {
        return developApplication;
    }

    public void setDevelopApplication(String developApplication) {
        this.developApplication = developApplication == null ? null : developApplication.trim();
    }

    public String getRealizeManner() {
        return realizeManner;
    }

    public void setRealizeManner(String realizeManner) {
        this.realizeManner = realizeManner == null ? null : realizeManner.trim();
    }

    public String getOtherManner() {
        return otherManner;
    }

    public void setOtherManner(String otherManner) {
        this.otherManner = otherManner == null ? null : otherManner.trim();
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription == null ? null : serviceDescription.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }
}
