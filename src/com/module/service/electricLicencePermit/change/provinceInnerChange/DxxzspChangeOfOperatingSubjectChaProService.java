package com.module.service.electricLicencePermit.change.provinceInnerChange;

import java.util.Map;

import com.util.AppException;

//1、国内互联网虚拟专用网业务
public interface DxxzspChangeOfOperatingSubjectChaProService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

