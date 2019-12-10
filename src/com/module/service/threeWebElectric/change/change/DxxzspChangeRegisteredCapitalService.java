package com.module.service.threeWebElectric.change.change;

import java.util.Map;

import com.util.AppException;


//注册资本变更
public interface DxxzspChangeRegisteredCapitalService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
