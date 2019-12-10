package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//2、顶级域基本情况表
public interface IDxxzspDomainBaseService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
