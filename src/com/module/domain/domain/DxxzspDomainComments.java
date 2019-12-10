package com.module.domain.domain;

import java.util.Date;

public class DxxzspDomainComments {
    private String id;

    private String flowrunid;

    private String flowrunsubject;

    private String nodeid;

    private String nodename;

    private String formname;

    private String itemid;

    private String auditstatus;

    private String auditcomments;

    private Date audittime;

    private String auditor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFlowrunid() {
        return flowrunid;
    }

    public void setFlowrunid(String flowrunid) {
        this.flowrunid = flowrunid == null ? null : flowrunid.trim();
    }

    public String getFlowrunsubject() {
        return flowrunsubject;
    }

    public void setFlowrunsubject(String flowrunsubject) {
        this.flowrunsubject = flowrunsubject == null ? null : flowrunsubject.trim();
    }

    public String getNodeid() {
        return nodeid;
    }

    public void setNodeid(String nodeid) {
        this.nodeid = nodeid == null ? null : nodeid.trim();
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename == null ? null : nodename.trim();
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname == null ? null : formname.trim();
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus == null ? null : auditstatus.trim();
    }

    public String getAuditcomments() {
        return auditcomments;
    }

    public void setAuditcomments(String auditcomments) {
        this.auditcomments = auditcomments == null ? null : auditcomments.trim();
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }
}