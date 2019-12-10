package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//6、信息安全保障措施
public interface IDxxzspDomainInfosafetyService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
