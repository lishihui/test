package com.module.domain.homePage;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
*@author awl
*
*/
public class LicenseBaseInfo {
	private String licid;//许可证唯一标识
	private String num;//许可证编号
	private String gsmc;//公司名称
	private String flag;//状态0临时证1正常的证-1已注销-2已吊销
	private String frdb;//法定代表人
	private String regcapital;//注册资本
	public String getRegcapital() {
		return regcapital;
	}
	public void setRegcapital(String regcapital) {
		this.regcapital = regcapital;
	}
	private String spe_address;//注册地
	private String regaddress;//注册地址（企业表）
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;//许可证获得日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validity;//许可证有效期
	private String isnotice;//是否已通知企业来领取0未通知1已通知
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date noticedate;//通知时间
	private String islicensing;//是否已领证0未领证1已领证
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date licensingdate;//领证时间
	private String licensingpersonname;//领证人姓名
	private String licensingpersoncode;//领证人证件号
	private String licensingmobile;//领证人联系方式(手机号)
	private String datacomplete;//材料是否齐备0未齐备1齐备
	private String needfile;//是否需要扫描件上传0不需1需要
	private String fileid;//扫描件ID
	private String note;//备注
	private String entid;//企业ID
	
	public String getLicid() {
		return licid;
	}
	public void setLicid(String licid) {
		this.licid = licid;
	}
	public String getEntid() {
		return entid;
	}
	public void setEntid(String entid) {
		this.entid = entid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLicensingpersonname() {
		return licensingpersonname;
	}
	public String getRegaddress() {
		return regaddress;
	}
	public void setRegaddress(String regaddress) {
		this.regaddress = regaddress;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getValidity() {
		return validity;
	}
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	public void setLicensingpersonname(String licensingpersonname) {
		this.licensingpersonname = licensingpersonname;
	}
	public String getLicensingpersoncode() {
		return licensingpersoncode;
	}
	public void setLicensingpersoncode(String licensingpersoncode) {
		this.licensingpersoncode = licensingpersoncode;
	}
	public String getIslicensing() {
		return islicensing;
	}
	public void setIslicensing(String islicensing) {
		this.islicensing = islicensing;
	}
	public String getIsnotice() {
		return isnotice;
	}
	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}
	public Date getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(Date noticedate) {
		this.noticedate = noticedate;
	}
	public Date getLicensingdate() {
		return licensingdate;
	}
	public void setLicensingdate(Date licensingdate) {
		this.licensingdate = licensingdate;
	}
	public String getDatacomplete() {
		return datacomplete;
	}
	public void setDatacomplete(String datacomplete) {
		this.datacomplete = datacomplete;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLicensingmobile() {
		return licensingmobile;
	}
	public void setLicensingmobile(String licensingmobile) {
		this.licensingmobile = licensingmobile;
	}
	public String getNeedfile() {
		return needfile;
	}
	public void setNeedfile(String needfile) {
		this.needfile = needfile;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getSpe_address() {
		return spe_address;
	}
	public void setSpe_address(String spe_address) {
		this.spe_address = spe_address;
	}
	public String getGsmc() {
		return gsmc;
	}
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}
	public String getFrdb() {
		return frdb;
	}
	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}
}
