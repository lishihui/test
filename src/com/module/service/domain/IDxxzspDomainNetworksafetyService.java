package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//7、网络安全保障措施
public interface IDxxzspDomainNetworksafetyService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
