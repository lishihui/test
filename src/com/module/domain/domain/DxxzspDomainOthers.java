package com.module.domain.domain;

import java.util.Date;

public class DxxzspDomainOthers {
    private String id;

    private String newstitle;

    private Date createTime;

    private Date modifieTime;

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

    public String getOtherMatersFlex() {
        return otherMatersFlex;
    }

    public void setOtherMatersFlex(String otherMatersFlex) {
        this.otherMatersFlex = otherMatersFlex == null ? null : otherMatersFlex.trim();
    }
}