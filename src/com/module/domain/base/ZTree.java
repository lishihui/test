package com.module.domain.base;

public class ZTree implements java.io.Serializable {

	private static final long serialVersionUID = -3839946904766584505L;
	
	private String id;//ID
	private String uuid;//除ID外的唯一值
	private String name;//显示名
	private boolean checked = false;//是否选中
	private boolean open;
	private String pId;//上级id  不用全小写因为ZTREE JS组件问题
	private String classflag;//是否分类目录 扫描模块使用
	private String pagnum;//是否分类目录 扫描模块使用
	private boolean nocheck = false;//是否显示可选
	
	private String menuaction="";//菜单URL
	private String level;//级别
	private String menuState;//状态
	private String sortnum;//排序

	public String getClassflag() {
		return classflag;
	}

	public void setClassflag(String classflag) {
		this.classflag = classflag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPagnum() {
		return pagnum;
	}

	public void setPagnum(String pagnum) {
		this.pagnum = pagnum;
	}

	public boolean isNocheck() {
		return nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

	public String getMenuaction() {
		return menuaction;
	}

	public void setMenuaction(String menuaction) {
		this.menuaction = menuaction;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMenuState() {
		return menuState;
	}

	public void setMenuState(String menuState) {
		this.menuState = menuState;
	}

	public String getSortnum() {
		return sortnum;
	}

	public void setSortnum(String sortnum) {
		this.sortnum = sortnum;
	}

}
