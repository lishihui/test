package com.module.domain.homePage;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author awl
 * 许可证查询实体类
 */
public class LicFormModel {
	
	
	private int lid;//主键
	private String licid;//许可证唯一标识
	private String num;//许可证编号
	private String flag;//状态0临时证1正常的证-1已注销-2已吊销
	private String entid;//企业ID
	private String provinceid;//省号
	private String regdate;//许可证获得日期
	private String validity;//许可证有效期
	private String lasteditdate;//最后变更日期
	
	private String version;//版本号
	private String yewu;//业务名称、类别字符串
	private String ywfw;//业务范围
	private String provincename;//省名称
	
	private String regcode;//公司统一社会信用代码
	private String corporatename;//法人名称
	private String corporatecode;//法人身份证号
	private String gsmc;//公司名称
	private String frdb;//法人代表
	
	private String lzr;
	
	public String getLzr() {
		return lzr;
	}
	public void setLzr(String lzr) {
		this.lzr = lzr;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sendDate;
	private Integer validDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date crateDate;
	
	
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Integer getValidDate() {
		return validDate;
	}
	public void setValidDate(Integer validDate) {
		this.validDate = validDate;
	}
	public String getLicid() {
		return licid;
	}
	public void setLicid(String licid) {
		this.licid = licid;
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
	public String getEntid() {
		return entid;
	}
	public void setEntid(String entid) {
		this.entid = entid;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getLasteditdate() {
		return lasteditdate;
	}
	public void setLasteditdate(String lasteditdate) {
		this.lasteditdate = lasteditdate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getYewu() {
		return yewu;
	}
	public void setYewu(String yewu) {
		this.yewu = yewu;
	}
	public String getYwfw() {
		return ywfw;
	}
	public void setYwfw(String ywfw) {
		this.ywfw = ywfw;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	public String getRegcode() {
		return regcode;
	}
	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}
	public String getCorporatename() {
		return corporatename;
	}
	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}
	public String getCorporatecode() {
		return corporatecode;
	}
	public void setCorporatecode(String corporatecode) {
		this.corporatecode = corporatecode;
	}
	public Date getCrateDate() {
		return crateDate;
	}
	public void setCrateDate(Date crateDate) {
		this.crateDate = crateDate;
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
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	
}
