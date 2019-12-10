package com.module.service.domain;

import java.util.Map;
import com.util.AppException;

//1、申请表单
public interface IDxxzspDomainApplytaskService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
