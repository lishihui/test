package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//4、 公司概况表
public interface IDxxzspDomainCompanyService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
