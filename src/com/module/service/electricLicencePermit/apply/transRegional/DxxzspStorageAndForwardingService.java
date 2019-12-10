package com.module.service.electricLicencePermit.apply.transRegional;

import java.util.Map;

import com.util.AppException;


//存储转发类业务
public interface DxxzspStorageAndForwardingService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
