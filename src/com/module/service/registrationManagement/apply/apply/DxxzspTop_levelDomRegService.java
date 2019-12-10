package com.module.service.registrationManagement.apply.apply;

import java.util.Map;

import com.util.AppException;


//顶级域注册管理系统相关协议
public interface DxxzspTop_levelDomRegService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

