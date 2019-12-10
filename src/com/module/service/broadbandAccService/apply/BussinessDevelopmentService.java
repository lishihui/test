package com.module.service.broadbandAccService.apply;

import java.util.Map;
import com.util.AppException;

//业务发展和实施计划专用表(bussinessDevelopment)
public interface BussinessDevelopmentService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
