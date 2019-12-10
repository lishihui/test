package com.module.service.ftaTradeApplication.apply.apply;

import java.util.Map;

import com.util.AppException;

//1、国内互联网虚拟专用网业务
public interface DxxzspMultipartyCommServeFtaService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

