package com.module.domain.pub;

import java.util.Date;

public class ItemFormUserHis {
    private String id;

    private String itemid;

    private String yewucode;

    private String dormname;

    private String formstatus;

    private Date lastsubmittimes;

    private String formopinion;

    private String processId;

    private String taskId;

    private String operator;

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

    public String getYewucode() {
        return yewucode;
    }

    public void setYewucode(String yewucode) {
        this.yewucode = yewucode == null ? null : yewucode.trim();
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}