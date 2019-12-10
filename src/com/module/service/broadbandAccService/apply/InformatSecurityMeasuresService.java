package com.module.service.broadbandAccService.apply;

import java.util.Map;
import com.util.AppException;

//网络与信息安全保障措施
public interface InformatSecurityMeasuresService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
