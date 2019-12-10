package com.module.service.ftaTradeApplication.apply.apply;

import java.util.Map;

import com.util.AppException;

public interface DxxzspInternetAccessServicesFtaService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
