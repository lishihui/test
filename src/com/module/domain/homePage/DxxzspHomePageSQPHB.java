package com.module.domain.homePage;


/**
 * 首页申请业务排行榜实体
 * @author awl
 * 2019-11-22
 */
public class DxxzspHomePageSQPHB {
    private String id;
    private String sqphbDate;
    private String lcid;
    private String lcname;
    private String sqsl;
    private String dbsl;
    private String createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSqphbDate() {
		return sqphbDate;
	}
	public void setSqphbDate(String sqphbDate) {
		this.sqphbDate = sqphbDate;
	}
	public String getLcid() {
		return lcid;
	}
	public void setLcid(String lcid) {
		this.lcid = lcid;
	}
	public String getLcname() {
		return lcname;
	}
	public void setLcname(String lcname) {
		this.lcname = lcname;
	}
	public String getSqsl() {
		return sqsl;
	}
	public void setSqsl(String sqsl) {
		this.sqsl = sqsl;
	}
	public String getDbsl() {
		return dbsl;
	}
	public void setDbsl(String dbsl) {
		this.dbsl = dbsl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "DxxzspHomePageSQPHB [id=" + id + ", sqphbDate=" + sqphbDate + ", lcid=" + lcid + ", lcname=" + lcname
				+ ", sqsl=" + sqsl + ", dbsl=" + dbsl + ", createTime=" + createTime + "]";
	}
}