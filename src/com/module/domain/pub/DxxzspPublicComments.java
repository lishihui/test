package com.module.domain.pub;

import java.util.Date;

public class DxxzspPublicComments {

    private String userid;  // 非数据库中的字段

    private String id;

    private String newstitle;

    private Date createTime;

    private Date modifieTime;

    private String creator;

    private String modificator;

    private String recycle;

    private String sjid;

    private String workid;

    private String nodename;

    private String formid;

    private String divid;

    private String yijian;

    private String pici;

    private String yijianvalue;

    private String nodeid;

    private String remark;

    private String username;

    private String type;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

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

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid == null ? null : sjid.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename == null ? null : nodename.trim();
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid == null ? null : formid.trim();
    }

    public String getDivid() {
        return divid;
    }

    public void setDivid(String divid) {
        this.divid = divid == null ? null : divid.trim();
    }

    public String getYijian() {
        return yijian;
    }

    public void setYijian(String yijian) {
        this.yijian = yijian == null ? null : yijian.trim();
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici == null ? null : pici.trim();
    }

    public String getYijianvalue() {
        return yijianvalue;
    }

    public void setYijianvalue(String yijianvalue) {
        this.yijianvalue = yijianvalue == null ? null : yijianvalue.trim();
    }

    public String getNodeid() {
        return nodeid;
    }

    public void setNodeid(String nodeid) {
        this.nodeid = nodeid == null ? null : nodeid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}