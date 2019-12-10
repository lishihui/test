package com.module.service.domainRegistration.change.change;

import java.util.Map;

import com.util.AppException;


//域名注册服务机构服务范围调整变更申请
public interface DxxzspTerminationRealmChangeChaFivService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
