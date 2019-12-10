package com.module.service.internetDomainRootServices.apply.apply;

import java.util.Map;

import com.util.AppException;


//电信管理机构要求提供的其他材料
public interface DxxzspTelecommManaReqIntService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
