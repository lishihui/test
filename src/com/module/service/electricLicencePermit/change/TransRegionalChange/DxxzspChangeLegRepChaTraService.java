package com.module.service.electricLicencePermit.change.TransRegionalChange;


import java.util.Map;

import com.util.AppException;

//法定代表人变更
public interface DxxzspChangeLegRepChaTraService {
	//根据主键查询业务数据
		 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
