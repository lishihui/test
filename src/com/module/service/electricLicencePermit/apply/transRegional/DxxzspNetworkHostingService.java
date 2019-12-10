package com.module.service.electricLicencePermit.apply.transRegional;

import java.util.Map;

import com.util.AppException;

//1、网络托管业务
public interface DxxzspNetworkHostingService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

