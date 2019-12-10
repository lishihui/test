package com.module.domain.homePage;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author awl
 * 公司记录表
 */
public class EntBaseInfo {
	private String regcode;//社会统一社会信用代码REGCODE, 
	private String regorgan;//注册机关 REGORGAN, 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date founddate;//成立日期FOUNDDATE, 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validitydate;//有效期VALIDITYDATE, 
	private String registerprovince;//注册省份REGISTERPROVINCE,
	private String registercity;//注册城市REGISTERCITY, 
	private String regcapital;//注册资金REGCAPITAL, 
	private String entemail;//企业邮箱ENTEMAIL, 
	private String nature;//企业性质NATURE, 
	private String entfax;//企业传真ENTFAX, 
	private String address;//地址ADDRESS, 
	private String corporatename;//法定代表人姓名CORPORATENAME, 
	private String corporatecodetype;//法定代表人证件类型CORPORATECODETYPE, 
	private String corporatecode;//法定代表人证件号CORPORATECODE, 
	private String corporatemobile;//法定代表人手机CORPORATEMOBILE, 
	private String corporatephone;//法定代表人固话CORPORATEPHONE, 
	private String corporatemail;//法定代表人邮箱CORPORATEMAIL, 
  	private String chargename;//负责人姓名CHARGENAME, 
  	private String chargemobile;//负责人手机CHARGEMOBILE, 
  	private String chargephone;//负责人固话CHARGEPHONE, 
  	private String chargeemail;//负责人邮箱CHARGEEMAIL, 
  	private String linkman;//联系人LINKMAN, 
  	private String linkmobile;//联系人手机LINKMOBILE, 
  	private String linkphone;//联系人固话LINKPHONE, 
  	private String linkemail;//联系人邮箱LINKEMAIL, 
  	private String islisted;//是否上市ISLISTED, 
  	private String listedaddress;//上市地点LISTEDADDRESS
	public String getRegcode() {
		return regcode;
	}
	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}
	public String getRegorgan() {
		return regorgan;
	}
	public void setRegorgan(String regorgan) {
		this.regorgan = regorgan;
	}
	public Date getFounddate() {
		return founddate;
	}
	public void setFounddate(Date founddate) {
		this.founddate = founddate;
	}
	public Date getValiditydate() {
		return validitydate;
	}
	public void setValiditydate(Date validitydate) {
		this.validitydate = validitydate;
	}
	public String getRegisterprovince() {
		return registerprovince;
	}
	public void setRegisterprovince(String registerprovince) {
		this.registerprovince = registerprovince;
	}
	public String getRegistercity() {
		return registercity;
	}
	public void setRegistercity(String registercity) {
		this.registercity = registercity;
	}
	public String getRegcapital() {
		return regcapital;
	}
	public void setRegcapital(String regcapital) {
		this.regcapital = regcapital;
	}
	public String getEntemail() {
		return entemail;
	}
	public void setEntemail(String entemail) {
		this.entemail = entemail;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getEntfax() {
		return entfax;
	}
	public void setEntfax(String entfax) {
		this.entfax = entfax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCorporatename() {
		return corporatename;
	}
	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}
	public String getCorporatecodetype() {
		return corporatecodetype;
	}
	public void setCorporatecodetype(String corporatecodetype) {
		this.corporatecodetype = corporatecodetype;
	}
	public String getCorporatecode() {
		return corporatecode;
	}
	public void setCorporatecode(String corporatecode) {
		this.corporatecode = corporatecode;
	}
	public String getCorporatemobile() {
		return corporatemobile;
	}
	public void setCorporatemobile(String corporatemobile) {
		this.corporatemobile = corporatemobile;
	}
	public String getCorporatephone() {
		return corporatephone;
	}
	public void setCorporatephone(String corporatephone) {
		this.corporatephone = corporatephone;
	}
	public String getCorporatemail() {
		return corporatemail;
	}
	public void setCorporatemail(String corporatemail) {
		this.corporatemail = corporatemail;
	}
	public String getChargename() {
		return chargename;
	}
	public void setChargename(String chargename) {
		this.chargename = chargename;
	}
	public String getChargemobile() {
		return chargemobile;
	}
	public void setChargemobile(String chargemobile) {
		this.chargemobile = chargemobile;
	}
	public String getChargephone() {
		return chargephone;
	}
	public void setChargephone(String chargephone) {
		this.chargephone = chargephone;
	}
	public String getChargeemail() {
		return chargeemail;
	}
	public void setChargeemail(String chargeemail) {
		this.chargeemail = chargeemail;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinkmobile() {
		return linkmobile;
	}
	public void setLinkmobile(String linkmobile) {
		this.linkmobile = linkmobile;
	}
	public String getLinkphone() {
		return linkphone;
	}
	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}
	public String getLinkemail() {
		return linkemail;
	}
	public void setLinkemail(String linkemail) {
		this.linkemail = linkemail;
	}
	public String getIslisted() {
		return islisted;
	}
	public void setIslisted(String islisted) {
		this.islisted = islisted;
	}
	public String getListedaddress() {
		return listedaddress;
	}
	public void setListedaddress(String listedaddress) {
		this.listedaddress = listedaddress;
	}
}
