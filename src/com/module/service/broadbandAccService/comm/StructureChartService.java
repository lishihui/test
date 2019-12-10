package com.module.service.broadbandAccService.comm;

import java.util.Map;
import com.util.AppException;

//完整详细的股权结构图
public interface StructureChartService {
	
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
