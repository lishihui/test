package com.module.service.ftaTradeApplication.change.comm;

import java.util.Map;

import com.util.AppException;

public interface DxxzspLicenseOfLegalPersonFtaService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

