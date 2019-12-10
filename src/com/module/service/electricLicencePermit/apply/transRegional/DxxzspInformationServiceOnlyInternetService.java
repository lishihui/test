package com.module.service.electricLicencePermit.apply.transRegional;

import java.util.Map;

import com.util.AppException;

//1、信息服务（仅限互联网信息服务）业务
public interface DxxzspInformationServiceOnlyInternetService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

