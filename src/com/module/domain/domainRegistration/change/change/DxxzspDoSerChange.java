package com.module.domain.domainRegistration.change.change;

public class DxxzspDoSerChange {
    private String id;

    private String title;

    private String created;

    private String modified;

    private String creator;

    private String modificator;

    private String recycle;

    private String adddomain;

    private String newstatrdate;

    private String newenddate;

    private String parentid;

    private String islongtime;

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

    public String getAdddomain() {
        return adddomain;
    }

    public void setAdddomain(String adddomain) {
        this.adddomain = adddomain == null ? null : adddomain.trim();
    }

    public String getNewstatrdate() {
        return newstatrdate;
    }

    public void setNewstatrdate(String newstatrdate) {
        this.newstatrdate = newstatrdate == null ? null : newstatrdate.trim();
    }

    public String getNewenddate() {
        return newenddate;
    }

    public void setNewenddate(String newenddate) {
        this.newenddate = newenddate == null ? null : newenddate.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getIslongtime() {
        return islongtime;
    }

    public void setIslongtime(String islongtime) {
        this.islongtime = islongtime == null ? null : islongtime.trim();
    }
}