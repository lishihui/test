package com.module.service.broadbandAccService.apply;

import java.util.Map;
import com.util.AppException;
//网络与技术方案专用表格
public interface NetworkTechnicalService {
	//根据主键查询业务数据
    public Map<String,Object> getRow(String id,String flowrunid) throws AppException;
}
