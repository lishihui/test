package com.module.service.domainRegistration.apply.apply;

import java.util.Map;

import com.util.AppException;

public interface DxxzspRegistrationServRelSysDomService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
