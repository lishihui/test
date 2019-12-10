package com.module.domain.domain;

import java.util.Date;

public class DxxzspDomainBase {
    private String id;

    private String newstitle;

    private Date createTime;

    private Date modifieTime;

    private String creator;

    private String modificator;

    private String recycle;

    private String domainOpenCoverage;

    private String marketSituation;

    private String domainSituation;

    private String others;

    private String pidParent;

    private String pidDtid;

    private String status;

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

    public String getDomainOpenCoverage() {
        return domainOpenCoverage;
    }

    public void setDomainOpenCoverage(String domainOpenCoverage) {
        this.domainOpenCoverage = domainOpenCoverage == null ? null : domainOpenCoverage.trim();
    }

    public String getMarketSituation() {
        return marketSituation;
    }

    public void setMarketSituation(String marketSituation) {
        this.marketSituation = marketSituation == null ? null : marketSituation.trim();
    }

    public String getDomainSituation() {
        return domainSituation;
    }

    public void setDomainSituation(String domainSituation) {
        this.domainSituation = domainSituation == null ? null : domainSituation.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }

    public String getPidParent() {
        return pidParent;
    }

    public void setPidParent(String pidParent) {
        this.pidParent = pidParent == null ? null : pidParent.trim();
    }

    public String getPidDtid() {
        return pidDtid;
    }

    public void setPidDtid(String pidDtid) {
        this.pidDtid = pidDtid == null ? null : pidDtid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}