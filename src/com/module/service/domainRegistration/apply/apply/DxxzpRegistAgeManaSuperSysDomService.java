package com.module.service.domainRegistration.apply.apply;

import java.util.Map;

import com.util.AppException;


//域名注册代理机构管理和监督制度
public interface DxxzpRegistAgeManaSuperSysDomService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
