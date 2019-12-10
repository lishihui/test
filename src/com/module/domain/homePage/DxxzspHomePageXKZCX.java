package com.module.domain.homePage;


/**
 * 首页许可证查询实体
 * @author awl
 * 2019-11-22
 */
public class DxxzspHomePageXKZCX {
    private String id;
    private String type;
    private String year;
    private String month;
    private String day;
    private String sj;
    private String bj;
    private String time;
	@Override
	public String toString() {
		return "DxxzspHomePageBMYWDT [id=" + id + ", type=" + type + ", year=" + year + ", month=" + month + ", day="
				+ day + ", sj=" + sj + ", bj=" + bj + ", time=" + time + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public String getBj() {
		return bj;
	}
	public void setBj(String bj) {
		this.bj = bj;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}