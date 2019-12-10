package com.module.service.registrationManagement.change.change;

import java.util.Map;

import com.util.AppException;
public interface DxxzspDjymglxgxylistChaService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
