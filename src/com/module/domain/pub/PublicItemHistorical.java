package com.module.domain.pub;
import java.util.Date;

public class PublicItemHistorical {
    private String id;

    private String itemid;

    private String formid;

    private String dormname;

    private String formstatus;

    private Date lastsubmittimes;

    private String formopinion;

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

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid == null ? null : formid.trim();
    }

    public String getDormname() {
        return dormname;
    }

    public void setDormname(String dormname) {
        this.dormname = dormname == null ? null : dormname.trim();
    }

    public String getFormstatus() {
        return formstatus;
    }

    public void setFormstatus(String formstatus) {
        this.formstatus = formstatus == null ? null : formstatus.trim();
    }

    public Date getLastsubmittimes() {
        return lastsubmittimes;
    }

    public void setLastsubmittimes(Date lastsubmittimes) {
        this.lastsubmittimes = lastsubmittimes;
    }

    public String getFormopinion() {
        return formopinion;
    }

    public void setFormopinion(String formopinion) {
        this.formopinion = formopinion == null ? null : formopinion.trim();
    }
}