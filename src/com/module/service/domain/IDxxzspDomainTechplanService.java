package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//5、 技术实施方案表
public interface IDxxzspDomainTechplanService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
