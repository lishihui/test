package com.module.domain.domain;

import java.util.Date;

public class FormMeta {
    private String id;

    private String key;

    private String name;

    private String type;

    private String typeId;

    private String opinionConf;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String createOrgId;

    private String desc;

    private Integer rev;

    private String subentity;

    private String mainalias;

    private String macroalias;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getOpinionConf() {
        return opinionConf;
    }

    public void setOpinionConf(String opinionConf) {
        this.opinionConf = opinionConf == null ? null : opinionConf.trim();
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

    public String getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId == null ? null : createOrgId.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getSubentity() {
        return subentity;
    }

    public void setSubentity(String subentity) {
        this.subentity = subentity == null ? null : subentity.trim();
    }

    public String getMainalias() {
        return mainalias;
    }

    public void setMainalias(String mainalias) {
        this.mainalias = mainalias == null ? null : mainalias.trim();
    }

    public String getMacroalias() {
        return macroalias;
    }

    public void setMacroalias(String macroalias) {
        this.macroalias = macroalias == null ? null : macroalias.trim();
    }
}