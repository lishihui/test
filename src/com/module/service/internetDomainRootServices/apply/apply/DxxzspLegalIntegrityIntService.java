package com.module.service.internetDomainRootServices.apply.apply;

import java.util.Map;
import com.util.AppException;


//依法经营和诚信经营承诺书
public interface DxxzspLegalIntegrityIntService {
	//根据主键查询业务数据
	 public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
