package com.module.domain.ftaTradeApplication.change.change;

public class DxxzspRfcLegalFta {
    private String id;

    private String created;

    private String modified;

    private String creator;

    private String modificator;

    private String recycle;

    private String oldName;

    private String oldIdcard;

    private String newName;

    private String newIdcard;

    private String changedReason;

    private String rfcInfoId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName == null ? null : oldName.trim();
    }

    public String getOldIdcard() {
        return oldIdcard;
    }

    public void setOldIdcard(String oldIdcard) {
        this.oldIdcard = oldIdcard == null ? null : oldIdcard.trim();
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName == null ? null : newName.trim();
    }

    public String getNewIdcard() {
        return newIdcard;
    }

    public void setNewIdcard(String newIdcard) {
        this.newIdcard = newIdcard == null ? null : newIdcard.trim();
    }

    public String getChangedReason() {
        return changedReason;
    }

    public void setChangedReason(String changedReason) {
        this.changedReason = changedReason == null ? null : changedReason.trim();
    }

    public String getRfcInfoId() {
        return rfcInfoId;
    }

    public void setRfcInfoId(String rfcInfoId) {
        this.rfcInfoId = rfcInfoId == null ? null : rfcInfoId.trim();
    }
}