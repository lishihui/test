package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//9、顶级域注册管理系统相关协议列表
public interface IDxxzspDomainAgreementService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
