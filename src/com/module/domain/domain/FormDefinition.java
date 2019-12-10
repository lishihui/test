package com.module.domain.domain;

import java.util.Date;

public class FormDefinition {
    private String id;

    private String defId;

    private String name;

    private String formKey;

    private String desc;

    private String status;

    private String formType;

    private String typeId;

    private String typeName;

    private String isMain;

    private Integer version;

    private String createBy;

    private Date createTime;

    private String createOrgId;

    private String updateBy;

    private Date updateTime;

    private String formTabTitle;

    private String classify;

    private String pageForms;

    private String pageFormJson;

    private String hideMain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDefId() {
        return defId;
    }

    public void setDefId(String defId) {
        this.defId = defId == null ? null : defId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey == null ? null : formKey.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType == null ? null : formType.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain == null ? null : isMain.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId == null ? null : createOrgId.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFormTabTitle() {
        return formTabTitle;
    }

    public void setFormTabTitle(String formTabTitle) {
        this.formTabTitle = formTabTitle == null ? null : formTabTitle.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getPageForms() {
        return pageForms;
    }

    public void setPageForms(String pageForms) {
        this.pageForms = pageForms == null ? null : pageForms.trim();
    }

    public String getPageFormJson() {
        return pageFormJson;
    }

    public void setPageFormJson(String pageFormJson) {
        this.pageFormJson = pageFormJson == null ? null : pageFormJson.trim();
    }

    public String getHideMain() {
        return hideMain;
    }

    public void setHideMain(String hideMain) {
        this.hideMain = hideMain == null ? null : hideMain.trim();
    }
}