package com.module.service.ftaTradeApplication.apply.apply;

import java.util.Map;

import com.util.AppException;


//信息服务(仅限互联网信息服务)业务
public interface DxxzspInforServInterOnlyFtaService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

