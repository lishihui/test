package com.module.domain.registrationManagement.apply.apply;

public class DxxzspTelecommManaReq {
    private String id;

    private String title;

    private String created;

    private String modified;

    private String creator;

    private String modificator;

    private String recycle;

    private String otherMatersFlex;

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

    public String getOtherMatersFlex() {
        return otherMatersFlex;
    }

    public void setOtherMatersFlex(String otherMatersFlex) {
        this.otherMatersFlex = otherMatersFlex == null ? null : otherMatersFlex.trim();
    }
}