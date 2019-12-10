package com.module.service.electricLicencePermit.apply.provinceInner;

import java.util.Map;

import com.util.AppException;

//1、互联网数据中心业务
public interface DxxzspDataCenterBusinesProService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

