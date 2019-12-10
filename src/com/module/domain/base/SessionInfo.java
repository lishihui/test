package com.module.domain.base;


public class SessionInfo implements java.io.Serializable {

	private static final long serialVersionUID = 7120523596175987438L;

    private String staffid;//用户编码

    private String staffname;//用户名称
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

}
