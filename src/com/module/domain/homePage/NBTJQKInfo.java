package com.module.domain.homePage;


/**
 * @author awl
 * 年报提交情况
 */
public class NBTJQKInfo {
	private String rptyear;//填报年份RPT_YEAR, 
	private String rptstatus;//填报情况RPT_STATUS 
	public String getRptyear() {
		return rptyear;
	}
	public void setRptyear(String rptyear) {
		this.rptyear = rptyear;
	}
	public String getRptstatus() {
		return rptstatus;
	}
	public void setRptstatus(String rptstatus) {
		this.rptstatus = rptstatus;
	}
}
