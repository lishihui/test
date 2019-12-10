package com.module.service.registrationManagement.apply.apply;

import java.util.Map;

import com.util.AppException;


//网络安全保障措施
public interface DxxzspNetworkSecurityService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
