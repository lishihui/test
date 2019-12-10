package com.module.domain.homePage;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author awl
 * 信誉信息
 */
public class XYInfo {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enroldate;//列入时间ENROLDATE, 
	private String enrolreason;//列入事由ENROLREASON, 
	private String enroldep;//执法部门ENROLDEP, 
	private String removereason;//移除事由REMOVEREASON, 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date removedate;//移除时间REMOVEDATE 
	public Date getEnroldate() {
		return enroldate;
	}
	public void setEnroldate(Date enroldate) {
		this.enroldate = enroldate;
	}
	public String getEnrolreason() {
		return enrolreason;
	}
	public void setEnrolreason(String enrolreason) {
		this.enrolreason = enrolreason;
	}
	public String getEnroldep() {
		return enroldep;
	}
	public void setEnroldep(String enroldep) {
		this.enroldep = enroldep;
	}
	public String getRemovereason() {
		return removereason;
	}
	public void setRemovereason(String removereason) {
		this.removereason = removereason;
	}
	public Date getRemovedate() {
		return removedate;
	}
	public void setRemovedate(Date removedate) {
		this.removedate = removedate;
	}
}
