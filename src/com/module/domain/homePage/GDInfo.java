package com.module.domain.homePage;


/**
 * @author awl
 * 股东信息
 */
public class GDInfo {
	private String name;//法人股东或自然人股东名称NAME, 
	private String idcard;//股东证件号IDCARD, 
	private String capitalpercent;//出资比例CAPITALPERCENT
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getCapitalpercent() {
		return capitalpercent;
	}
	public void setCapitalpercent(String capitalpercent) {
		this.capitalpercent = capitalpercent;
	}
}
