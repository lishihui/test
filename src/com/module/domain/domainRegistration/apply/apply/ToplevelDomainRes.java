package com.module.domain.domainRegistration.apply.apply;

public class ToplevelDomainRes {
    private String id;

    private String title;

    private String created;

    private String modified;

    private String creator;

    private String modificator;

    private String recycle;

    private String toplevelDomainName;

    private String htjzrq;

    private String contractDeadline;

    private String parentid;

    private String card;

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

    public String getToplevelDomainName() {
        return toplevelDomainName;
    }

    public void setToplevelDomainName(String toplevelDomainName) {
        this.toplevelDomainName = toplevelDomainName == null ? null : toplevelDomainName.trim();
    }

    public String getHtjzrq() {
        return htjzrq;
    }

    public void setHtjzrq(String htjzrq) {
        this.htjzrq = htjzrq == null ? null : htjzrq.trim();
    }

    public String getContractDeadline() {
        return contractDeadline;
    }

    public void setContractDeadline(String contractDeadline) {
        this.contractDeadline = contractDeadline == null ? null : contractDeadline.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }
}