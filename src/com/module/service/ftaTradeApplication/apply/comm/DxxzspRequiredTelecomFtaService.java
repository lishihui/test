package com.module.service.ftaTradeApplication.apply.comm;


import java.util.Map;

import com.util.AppException;


//电信主管部门要求提交的其他材料
public interface DxxzspRequiredTelecomFtaService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}

