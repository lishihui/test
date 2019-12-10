package com.module.domain.domain;

import java.util.Date;

public class DxxzspDomainCompanyTech {
    private String id;

    private String newstitle;

    private Date createTime;

    private Date modifieTime;

    private String creator;

    private String modificator;

    private String recycle;

    private String techName;

    private String techIdNum;

    private String techPost;

    private String techEducation;

    private String techPhone;

    private String techMobile;

    private String techEmail;

    private String parentid;

    private String techIdFlex;

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

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName == null ? null : techName.trim();
    }

    public String getTechIdNum() {
        return techIdNum;
    }

    public void setTechIdNum(String techIdNum) {
        this.techIdNum = techIdNum == null ? null : techIdNum.trim();
    }

    public String getTechPost() {
        return techPost;
    }

    public void setTechPost(String techPost) {
        this.techPost = techPost == null ? null : techPost.trim();
    }

    public String getTechEducation() {
        return techEducation;
    }

    public void setTechEducation(String techEducation) {
        this.techEducation = techEducation == null ? null : techEducation.trim();
    }

    public String getTechPhone() {
        return techPhone;
    }

    public void setTechPhone(String techPhone) {
        this.techPhone = techPhone == null ? null : techPhone.trim();
    }

    public String getTechMobile() {
        return techMobile;
    }

    public void setTechMobile(String techMobile) {
        this.techMobile = techMobile == null ? null : techMobile.trim();
    }

    public String getTechEmail() {
        return techEmail;
    }

    public void setTechEmail(String techEmail) {
        this.techEmail = techEmail == null ? null : techEmail.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getTechIdFlex() {
        return techIdFlex;
    }

    public void setTechIdFlex(String techIdFlex) {
        this.techIdFlex = techIdFlex == null ? null : techIdFlex.trim();
    }
}