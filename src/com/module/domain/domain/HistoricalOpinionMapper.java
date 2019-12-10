package com.module.domain.domain;

import java.util.Date;

public class HistoricalOpinionMapper {
    private String id;

    private String itemid;

    private String itemname;

    private String nodeid;

    private String nodename;

    private String fromid;

    private String fromname;

    private String fromstatus;

    private String creatruser;

    private String formopinion;

    private Date creatrdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
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

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid == null ? null : fromid.trim();
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname == null ? null : fromname.trim();
    }

    public String getFromstatus() {
        return fromstatus;
    }

    public void setFromstatus(String fromstatus) {
        this.fromstatus = fromstatus == null ? null : fromstatus.trim();
    }

    public String getCreatruser() {
        return creatruser;
    }

    public void setCreatruser(String creatruser) {
        this.creatruser = creatruser == null ? null : creatruser.trim();
    }

    public String getFormopinion() {
        return formopinion;
    }

    public void setFormopinion(String formopinion) {
        this.formopinion = formopinion == null ? null : formopinion.trim();
    }

    public Date getCreatrdate() {
        return creatrdate;
    }

    public void setCreatrdate(Date creatrdate) {
        this.creatrdate = creatrdate;
    }
}