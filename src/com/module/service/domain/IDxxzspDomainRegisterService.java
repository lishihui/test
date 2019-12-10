package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//3、域名注册管理机构申请表
public interface IDxxzspDomainRegisterService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
