package com.module.service.internetDomainRootServices.apply.apply;

import java.util.Map;
import com.util.AppException;


//域名根服务器及域名根服务器运行机构申请表
public interface DxxzspDomainrootserverIntSerivce {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
