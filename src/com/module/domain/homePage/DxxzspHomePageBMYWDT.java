package com.module.domain.homePage;

import java.util.Date;

/**
 * 首页部门业务动态实体
 * @author awl
 * 2019-11-22
 */
public class DxxzspHomePageBMYWDT {
    private Integer id;
    private String type;
    private String year;
    private String month;
    private String day;
    private String sj;
    private String bj;
    private String time;
    private Integer week;
    private Date createTime;
    private Integer shoujian;
    private Integer banjie;
	@Override
	public String toString() {
		return "DxxzspHomePageBMYWDT [id=" + id + ", type=" + type + ", year=" + year + ", month=" + month + ", day="
				+ day + ", sj=" + sj + ", bj=" + bj + ", time=" + time + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getShoujian() {
		return shoujian;
	}
	public void setShoujian(Integer shoujian) {
		this.shoujian = shoujian;
	}
	public Integer getBanjie() {
		return banjie;
	}
	public void setBanjie(Integer banjie) {
		this.banjie = banjie;
	}
	
	
}