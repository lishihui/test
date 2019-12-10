package com.module.domain.homePage;


/**
 * 首页统计表实体
 * @author awl
 * 2019-11-22
 */
public class DxxzspHomePageTJB {
    private String id;
    private String wd;
    private String zyi;
    private String zer;
    private String zsan;
    private String zsi;
    private String zwu;
    private String createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWd() {
		return wd;
	}
	public void setWd(String wd) {
		this.wd = wd;
	}
	public String getZyi() {
		return zyi;
	}
	public void setZyi(String zyi) {
		this.zyi = zyi;
	}
	public String getZer() {
		return zer;
	}
	public void setZer(String zer) {
		this.zer = zer;
	}
	public String getZsan() {
		return zsan;
	}
	public void setZsan(String zsan) {
		this.zsan = zsan;
	}
	public String getZsi() {
		return zsi;
	}
	public void setZsi(String zsi) {
		this.zsi = zsi;
	}
	public String getZwu() {
		return zwu;
	}
	public void setZwu(String zwu) {
		this.zwu = zwu;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "DxxzspHomePageTJB [id=" + id + ", wd=" + wd + ", zyi=" + zyi + ", zer=" + zer + ", zsan=" + zsan
				+ ", zsi=" + zsi + ", zwu=" + zwu + ", createTime=" + createTime + "]";
	}
}