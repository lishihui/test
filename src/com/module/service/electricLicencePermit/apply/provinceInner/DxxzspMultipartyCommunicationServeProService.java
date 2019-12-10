package com.module.service.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import com.util.AppException;

//1、国内多方通信服务业务
public interface DxxzspMultipartyCommunicationServeProService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

