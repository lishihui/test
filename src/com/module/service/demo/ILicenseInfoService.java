package com.module.service.demo;

import java.util.Map;

public interface ILicenseInfoService {
	
	public Map<String, Object> queryLiLicenseInfo(String num);
	
	public String changLicenseinfo(String num);
	
	public String getA12AndA08ServerAppinfo(String num);
	
	public String getZgsinfo(String num);

}
