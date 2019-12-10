package com.module.service.ftaTradeApplication.change.change;

import java.util.Map;

import com.util.AppException;


//服务项目变更
public interface DxxzspServiceItemChangeFtaService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}


