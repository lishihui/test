package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//8、域名注册管理相关制度
public interface IDxxzspDomainManagementService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
