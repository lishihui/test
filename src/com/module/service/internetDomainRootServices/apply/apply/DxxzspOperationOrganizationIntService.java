package com.module.service.internetDomainRootServices.apply.apply;

import java.util.Map;

import com.util.AppException;

//运营机构概况表格
public interface DxxzspOperationOrganizationIntService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
