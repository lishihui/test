package com.module.domain.domain;

import java.util.Date;

public class DxxzspDomainApprovals {
    private String id;

    private String newstitle;

    private Date createTime;

    private Date modifieTime;

    private String creator;

    private String modificator;

    private String recycle;

    private String orgName;

    private String approveDocumentCode;

    private String sqdjyym;

    private Date pfdate;

    private String yxqjzsj;

    private String orgId;

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getApproveDocumentCode() {
        return approveDocumentCode;
    }

    public void setApproveDocumentCode(String approveDocumentCode) {
        this.approveDocumentCode = approveDocumentCode == null ? null : approveDocumentCode.trim();
    }

    public String getSqdjyym() {
        return sqdjyym;
    }

    public void setSqdjyym(String sqdjyym) {
        this.sqdjyym = sqdjyym == null ? null : sqdjyym.trim();
    }

    public Date getPfdate() {
        return pfdate;
    }

    public void setPfdate(Date pfdate) {
        this.pfdate = pfdate;
    }

    public String getYxqjzsj() {
        return yxqjzsj;
    }

    public void setYxqjzsj(String yxqjzsj) {
        this.yxqjzsj = yxqjzsj == null ? null : yxqjzsj.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }
}