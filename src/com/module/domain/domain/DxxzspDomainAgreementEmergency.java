package com.module.domain.domain;

import java.util.Date;

public class DxxzspDomainAgreementEmergency {
    private String id;

    private String newstitle;

    private Date createTime;

    private Date modifieTime;

    private String creator;

    private String modificator;

    private String recycle;

    private String toplevelName;

    private String isSupport;

    private String clientName;

    private String parentid;

    private String fjid;

    private String files;

    private String toplevelbak;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle == null ? null : newstitle.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifieTime() {
        return modifieTime;
    }

    public void setModifieTime(Date modifieTime) {
        this.modifieTime = modifieTime;
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

    public String getToplevelName() {
        return toplevelName;
    }

    public void setToplevelName(String toplevelName) {
        this.toplevelName = toplevelName == null ? null : toplevelName.trim();
    }

    public String getIsSupport() {
        return isSupport;
    }

    public void setIsSupport(String isSupport) {
        this.isSupport = isSupport == null ? null : isSupport.trim();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getFjid() {
        return fjid;
    }

    public void setFjid(String fjid) {
        this.fjid = fjid == null ? null : fjid.trim();
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files == null ? null : files.trim();
    }

    public String getToplevelbak() {
        return toplevelbak;
    }

    public void setToplevelbak(String toplevelbak) {
        this.toplevelbak = toplevelbak == null ? null : toplevelbak.trim();
    }
}