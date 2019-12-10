package com.module.service.internetDomainRootServices.apply.apply;

import java.util.Map;
import com.util.AppException;


//网络安全保障制度
public interface DxxzspNetworkSecuritySystemIntService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

