package com.module.domain.base;

import java.io.Serializable;

/**下载返回许可申请数据
 * @author liulingyu
 *
 */
public class WetrilCnkiLicenseInfo implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String name;//许可证名字
	    private String num;//许可证号
	    private String yeWuName;//业务名字
	    private String ywfw;//范围
	    private String yeWuCode;
	    private String wcfFanwei;
	    private String fwName;
	    private String entId;
	    private String serverName;
	    private String chinaNet;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		public String getYeWuName() {
			return yeWuName;
		}
		public void setYeWuName(String yeWuName) {
			this.yeWuName = yeWuName;
		}
		public String getYwfw() {
			return ywfw;
		}
		public void setYwfw(String ywfw) {
			this.ywfw = ywfw;
		}
		public String getYeWuCode() {
			return yeWuCode;
		}
		public void setYeWuCode(String yeWuCode) {
			this.yeWuCode = yeWuCode;
		}
		public String getWcfFanwei() {
			return wcfFanwei;
		}
		public void setWcfFanwei(String wcfFanwei) {
			this.wcfFanwei = wcfFanwei;
		}
		public String getFwName() {
			return fwName;
		}
		public void setFwName(String fwName) {
			this.fwName = fwName;
		}
		public String getEntId() {
			return entId;
		}
		public void setEntId(String entId) {
			this.entId = entId;
		}
		public String getServerName() {
			return serverName;
		}
		public void setServerName(String serverName) {
			this.serverName = serverName;
		}
		public String getChinaNet() {
			return chinaNet;
		}
		public void setChinaNet(String chinaNet) {
			this.chinaNet = chinaNet;
		}
	    
	    
	    
	
}
