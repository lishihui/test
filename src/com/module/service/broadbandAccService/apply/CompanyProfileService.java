package com.module.service.broadbandAccService.apply;

import java.util.Map;
import com.util.AppException;

//公司概况表
public interface CompanyProfileService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
