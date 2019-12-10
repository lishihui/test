package com.module.service.domainRegistration.apply.apply;

import java.util.Map;

import com.util.AppException;


//实名核验系统对接情况
public interface DxxzspRealNameVerSysDomService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
